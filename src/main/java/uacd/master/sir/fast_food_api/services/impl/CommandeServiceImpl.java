package uacd.master.sir.fast_food_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uacd.master.sir.fast_food_api.dto.CommandeRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandeResponseDTO;
import uacd.master.sir.fast_food_api.models.Commande;
import uacd.master.sir.fast_food_api.models.Commandefastfood;
import uacd.master.sir.fast_food_api.models.Commandeproduit;
import uacd.master.sir.fast_food_api.repositories.CommandeRepository;
import uacd.master.sir.fast_food_api.repositories.CommandefastfoodRepository;
import uacd.master.sir.fast_food_api.repositories.CommandeproduitRepository;
import uacd.master.sir.fast_food_api.services.CommandeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {

    // Déclaration des repositories pour accéder aux données
    private final CommandeRepository commandeRepository;
    private final CommandefastfoodRepository commandefastfoodRepository;
    private final CommandeproduitRepository commandeproduitRepository;

    @Override
    @Transactional
    public CommandeResponseDTO createCommande(CommandeRequestDTO requestDTO) {
        Commande commande = new Commande();
        // Définir les champs de commande à partir du DTO de requête
        commande.setIdutilisateur(requestDTO.getIdutilisateur());
        commande.setDate(requestDTO.getDate());
        commande.setStatus(requestDTO.getStatus());

        Commande savedCommande = commandeRepository.save(commande);

        // Créer les entrées Commandefastfood
        if (requestDTO.getFastfoods() != null) {
            for (Integer fastfoodId : requestDTO.getFastfoods()) {
                Commandefastfood commandefastfood = new Commandefastfood();
                commandefastfood.setIdcommande(savedCommande.getIdcommande());
                commandefastfood.setIdfastfood(fastfoodId);
                commandefastfoodRepository.save(commandefastfood);
            }
        }

        // Créer les entrées Commandeproduit
        if (requestDTO.getProduits() != null) {
            for (Integer produitId : requestDTO.getProduits()) {
                Commandeproduit commandeproduit = new Commandeproduit();
                commandeproduit.setIdcommande(savedCommande.getIdcommande());
                commandeproduit.setIdproduit(produitId);
                commandeproduitRepository.save(commandeproduit);
            }
        }

        return convertToResponseDTO(savedCommande);
    }

    @Override
    public CommandeResponseDTO getCommande(int id) {
        // Recherche de l'entité Commande par son identifiant
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande not found"));
        return convertToResponseDTO(commande);
    }

    @Override
    public List<CommandeResponseDTO> getAllCommandes() {
        // Récupération de toutes les entités Commande et conversion en une liste de DTO de réponse
        return commandeRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CommandeResponseDTO updateCommande(int id, CommandeRequestDTO requestDTO) {
        // Recherche de l'entité Commande par son identifiant
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande not found"));

        // Mise à jour des champs de commande
        commande.setIdutilisateur(requestDTO.getIdutilisateur());
        commande.setDate(requestDTO.getDate());
        commande.setStatus(requestDTO.getStatus());

        Commande updatedCommande = commandeRepository.save(commande);

        // Mise à jour des entrées Commandefastfood
        commandefastfoodRepository.deleteByIdcommande(id);
        if (requestDTO.getFastfoods() != null) {
            for (Integer fastfoodId : requestDTO.getFastfoods()) {
                Commandefastfood commandefastfood = new Commandefastfood();
                commandefastfood.setIdcommande(id);
                commandefastfood.setIdfastfood(fastfoodId);
                commandefastfoodRepository.save(commandefastfood);
            }
        }

        // Mise à jour des entrées Commandeproduit
        commandeproduitRepository.deleteByIdcommande(id);
        if (requestDTO.getProduits() != null) {
            for (Integer produitId : requestDTO.getProduits()) {
                Commandeproduit commandeproduit = new Commandeproduit();
                commandeproduit.setIdcommande(id);
                commandeproduit.setIdproduit(produitId);
                commandeproduitRepository.save(commandeproduit);
            }
        }

        return convertToResponseDTO(updatedCommande);
    }

    @Override
    @Transactional
    public void deleteCommande(int id) {
        // Suppression des entrées Commandefastfood et Commandeproduit associées à la commande
        commandefastfoodRepository.deleteByIdcommande(id);
        commandeproduitRepository.deleteByIdcommande(id);
        // Suppression de la commande elle-même
        commandeRepository.deleteById(id);
    }

    // Méthode privée pour convertir une entité Commande en DTO de réponse
    private CommandeResponseDTO convertToResponseDTO(Commande commande) {
        CommandeResponseDTO responseDTO = new CommandeResponseDTO();
        // Définir les champs de responseDTO à partir de commande
        responseDTO.setIdcommande(commande.getIdcommande());
        responseDTO.setIdutilisateur(commande.getIdutilisateur());
        responseDTO.setDate(commande.getDate());
        responseDTO.setStatus(commande.getStatus());

        // Récupérer et définir les fastfoods et produits associés
        List<Integer> fastfoods = commandefastfoodRepository.findByIdcommande(commande.getIdcommande())
                .stream().map(Commandefastfood::getIdfastfood).collect(Collectors.toList());
        responseDTO.setFastfoods(fastfoods);

        List<Integer> produits = commandeproduitRepository.findByIdcommande(commande.getIdcommande())
                .stream().map(Commandeproduit::getIdproduit).collect(Collectors.toList());
        responseDTO.setProduits(produits);

        return responseDTO;
    }
}
