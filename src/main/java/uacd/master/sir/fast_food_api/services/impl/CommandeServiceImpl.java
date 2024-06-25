package uacd.master.sir.fast_food_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.dto.CommandeRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandeResponseDTO;
import uacd.master.sir.fast_food_api.models.Commande;
import uacd.master.sir.fast_food_api.repositories.CommandeRepository;
import uacd.master.sir.fast_food_api.services.CommandeService;

import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;

    @Override
    public CommandeResponseDTO createCommande(CommandeRequestDTO commandeRequestDTO) {
        Commande commande = new Commande();
        commande.setIdutilisateur(commandeRequestDTO.getIdutilisateur());
        commande.setDate(commandeRequestDTO.getDate());
        commande.setStatus(commandeRequestDTO.getStatus());
        Commande savedCommande = commandeRepository.save(commande);
        return mapToResponseDTO(savedCommande);
    }

    @Override
    public CommandeResponseDTO getCommandeById(int id) {
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande not found"));
        return mapToResponseDTO(commande);
    }

    @Override
    public List<CommandeResponseDTO> getAllCommandes() {
        return commandeRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public CommandeResponseDTO updateCommande(int id, CommandeRequestDTO commandeRequestDTO) {
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande not found"));
        commande.setIdutilisateur(commandeRequestDTO.getIdutilisateur());
        commande.setDate(commandeRequestDTO.getDate());
        commande.setStatus(commandeRequestDTO.getStatus());
        Commande updatedCommande = commandeRepository.save(commande);
        return mapToResponseDTO(updatedCommande);
    }

    @Override
    public void deleteCommande(int id) {
        commandeRepository.deleteById(id);
    }
    private CommandeResponseDTO mapToResponseDTO(Commande commande) {
        CommandeResponseDTO responseDTO = new CommandeResponseDTO();
        responseDTO.setIdcommande(commande.getIdcommande());
        responseDTO.setIdutilisateur(commande.getIdutilisateur());
        responseDTO.setDate(commande.getDate());
        responseDTO.setStatus(commande.getStatus());
        return responseDTO;
    }
}
