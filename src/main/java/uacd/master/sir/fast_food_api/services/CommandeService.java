package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.CommandeRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandeResponseDTO;

import java.util.List;

public interface CommandeService {
    CommandeResponseDTO createCommande(CommandeRequestDTO commandeRequestDTO);
    CommandeResponseDTO getCommandeById(int id);
    List<CommandeResponseDTO> getAllCommandes();
    CommandeResponseDTO updateCommande(int id, CommandeRequestDTO commandeRequestDTO);
    void deleteCommande(int id);
}
