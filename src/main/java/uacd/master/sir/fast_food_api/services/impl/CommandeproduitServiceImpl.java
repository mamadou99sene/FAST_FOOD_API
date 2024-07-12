package uacd.master.sir.fast_food_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.dto.CommandeproduitRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandeproduitResponseDTO;
import uacd.master.sir.fast_food_api.dto.ProduitResponseDTO;
import uacd.master.sir.fast_food_api.models.Commandeproduit;
import uacd.master.sir.fast_food_api.models.CommandeproduitPK;
import uacd.master.sir.fast_food_api.repositories.CommandeproduitRepository;
import uacd.master.sir.fast_food_api.repositories.ProduitRepository;
import uacd.master.sir.fast_food_api.services.CommandeproduitService;
import uacd.master.sir.fast_food_api.utils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeproduitServiceImpl implements CommandeproduitService {

    // Déclaration du repository pour accéder aux données de Commandeproduit
    private final CommandeproduitRepository commandeproduitRepository;
    private final ProduitRepository produitRepository;

    @Override
    public CommandeproduitResponseDTO createCommandeproduit(CommandeproduitRequestDTO requestDTO) {
        // Création d'une nouvelle entité Commandeproduit à partir du DTO de requête
        Commandeproduit commandeproduit = new Commandeproduit();
        commandeproduit.setIdcommande(requestDTO.getIdcommande());
        commandeproduit.setIdproduit(requestDTO.getIdproduit());

        // Sauvegarde de l'entité dans le repository et conversion en DTO de réponse
        Commandeproduit savedCommandeproduit = commandeproduitRepository.save(commandeproduit);
        return convertToResponseDTO(savedCommandeproduit);
    }

    @Override
    public CommandeproduitResponseDTO getCommandeproduit(int idcommande, int idproduit) {
        // Recherche de l'entité Commandeproduit par son identifiant composite
        CommandeproduitPK id = new CommandeproduitPK();
        id.setIdcommande(idcommande);
        id.setIdproduit(idproduit);
        Commandeproduit commandeproduit = commandeproduitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commandeproduit not found"));
        return convertToResponseDTO(commandeproduit);
    }

    @Override
    public List<CommandeproduitResponseDTO> getAllCommandeproduits() {
        // Récupération de toutes les entités Commandeproduit et conversion en une liste de DTO de réponse
        return commandeproduitRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeproduitResponseDTO updateCommandeproduit(int idcommande, int idproduit, CommandeproduitRequestDTO requestDTO) {
        // Recherche de l'entité Commandeproduit par son identifiant composite
        CommandeproduitPK id = new CommandeproduitPK();
        id.setIdcommande(idcommande);
        id.setIdproduit(idproduit);
        Commandeproduit commandeproduit = commandeproduitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commandeproduit not found"));

        // Sauvegarde de l'entité mise à jour dans le repository et conversion en DTO de réponse
        Commandeproduit updatedCommandeproduit = commandeproduitRepository.save(commandeproduit);
        return convertToResponseDTO(updatedCommandeproduit);
    }

    @Override
    public void deleteCommandeproduit(int idcommande, int idproduit) {
        // Suppression de l'entité Commandeproduit par son identifiant composite
        CommandeproduitPK id = new CommandeproduitPK();
        id.setIdcommande(idcommande);
        id.setIdproduit(idproduit);
        commandeproduitRepository.deleteById(id);
    }

    @Override
    public List<ProduitResponseDTO> getProductsByCommand(int idCommand) {
        List<ProduitResponseDTO> products= new ArrayList<>();
        List<Commandeproduit>commandeproduits = commandeproduitRepository.findByIdcommande(idCommand);
        for(Commandeproduit c: commandeproduits){
            ProduitResponseDTO produit = Mapper.convertToDTO(produitRepository.findProduitByIdproduit(c.getIdproduit()));
            products.add(produit);
        }
        return products;
    }

    // Méthode privée pour convertir une entité Commandeproduit en DTO de réponse
    private CommandeproduitResponseDTO convertToResponseDTO(Commandeproduit commandeproduit) {
        CommandeproduitResponseDTO responseDTO = new CommandeproduitResponseDTO();
        responseDTO.setIdcommande(commandeproduit.getIdcommande());
        responseDTO.setIdproduit(commandeproduit.getIdproduit());

        // Ajouter d'autres champs si nécessaire, par exemple pour le produit associé
        /*
        if (commandeproduit.getProduitByIdProduit() != null) {
            ProduitResponseDTO produitDTO = new ProduitResponseDTO();
            // Définir les champs de produitDTO en fonction de commandeproduit.getProduitByIdProduit()
            responseDTO.setProduitByIdProduit(produitDTO);
        }
        */

        return responseDTO;
    }
}
