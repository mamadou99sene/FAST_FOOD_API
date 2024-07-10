package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.CommandeRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandeResponseDTO;

import java.util.List;

public interface CommandeService {
    CommandeResponseDTO createCommande(CommandeRequestDTO requestDTO);
    CommandeResponseDTO getCommande(int id);
    List<CommandeResponseDTO> getAllCommandes();
    CommandeResponseDTO updateCommande(int id, CommandeRequestDTO requestDTO);
    void deleteCommande(int id);
}
