package uacd.master.sir.fast_food_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.dto.CommandefastfoodRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandefastfoodResponseDTO;
import uacd.master.sir.fast_food_api.models.Commandefastfood;
import uacd.master.sir.fast_food_api.models.CommandefastfoodPK;
import uacd.master.sir.fast_food_api.repositories.CommandefastfoodRepository;
import uacd.master.sir.fast_food_api.services.CommandefastfoodService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandefastfoodServiceImpl implements CommandefastfoodService {

    // Déclaration du repository pour accéder aux données de Commandefastfood
    private final CommandefastfoodRepository commandefastfoodRepository;

    @Override
    public CommandefastfoodResponseDTO createCommandefastfood(CommandefastfoodRequestDTO requestDTO) {
        // Création d'une nouvelle entité Commandefastfood à partir du DTO de requête
        Commandefastfood commandefastfood = new Commandefastfood();
        commandefastfood.setIdcommande(requestDTO.getIdcommande());
        commandefastfood.setIdfastfood(requestDTO.getIdfastfood());

        // Sauvegarde de l'entité dans le repository et conversion en DTO de réponse
        Commandefastfood savedCommandefastfood = commandefastfoodRepository.save(commandefastfood);
        return convertToResponseDTO(savedCommandefastfood);
    }

    @Override
    public CommandefastfoodResponseDTO getCommandefastfood(int idcommande, int idfastfood) {
        // Recherche de l'entité Commandefastfood par son identifiant composite
        CommandefastfoodPK id = new CommandefastfoodPK(idcommande, idfastfood);
        Commandefastfood commandefastfood = commandefastfoodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commandefastfood not found"));
        return convertToResponseDTO(commandefastfood);
    }

    @Override
    public List<CommandefastfoodResponseDTO> getAllCommandefastfoods() {
        // Récupération de toutes les entités Commandefastfood et conversion en une liste de DTO de réponse
        return commandefastfoodRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommandefastfoodResponseDTO updateCommandefastfood(int idcommande, int idfastfood, CommandefastfoodRequestDTO commandefastfoodRequestDTO) {
        // Recherche de l'entité Commandefastfood par son identifiant composite
        CommandefastfoodPK id = new CommandefastfoodPK(idcommande, idfastfood);
        Commandefastfood commandefastfood = commandefastfoodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commandefastfood not found"));

        // Mise à jour des champs si nécessaire

        // Sauvegarde de l'entité mise à jour dans le repository et conversion en DTO de réponse
        Commandefastfood updatedCommandefastfood = commandefastfoodRepository.save(commandefastfood);
        return convertToResponseDTO(updatedCommandefastfood);
    }

    @Override
    public void deleteCommandefastfood(int idcommande, int idfastfood) {
        // Suppression de l'entité Commandefastfood par son identifiant composite
        CommandefastfoodPK id = new CommandefastfoodPK(idcommande, idfastfood);
        commandefastfoodRepository.deleteById(id);
    }

    // Méthode privée pour convertir une entité Commandefastfood en DTO de réponse
    private CommandefastfoodResponseDTO convertToResponseDTO(Commandefastfood commandefastfood) {
        CommandefastfoodResponseDTO responseDTO = new CommandefastfoodResponseDTO();
        responseDTO.setIdcommande(commandefastfood.getIdcommande());
        responseDTO.setIdfastfood(commandefastfood.getIdfastfood());

        return responseDTO;
    }
}
