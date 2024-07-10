package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.CommandeproduitRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandeproduitResponseDTO;

import java.util.List;

public interface CommandeproduitService {
    CommandeproduitResponseDTO createCommandeproduit(CommandeproduitRequestDTO requestDTO);
    CommandeproduitResponseDTO getCommandeproduit(int idcommande, int idproduit);
    List<CommandeproduitResponseDTO> getAllCommandeproduits();
    CommandeproduitResponseDTO updateCommandeproduit(int idcommande, int idproduit, CommandeproduitRequestDTO requestDTO);
    void deleteCommandeproduit(int idcommande, int idproduit);
}