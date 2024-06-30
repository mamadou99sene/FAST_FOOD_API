package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.CommandefastfoodRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandefastfoodResponseDTO;

import java.util.List;

public interface CommandefastfoodService {
    CommandefastfoodResponseDTO createCommandefastfood(CommandefastfoodRequestDTO commandefastfoodRequestDTO);
    CommandefastfoodResponseDTO getCommandefastfoodById(int idcommande, int idfastfood);
    List<CommandefastfoodResponseDTO> getAllCommandefastfoods();
    CommandefastfoodResponseDTO updateCommandefastfood(int idcommande, int idfastfood, CommandefastfoodRequestDTO commandefastfoodRequestDTO);
    void deleteCommandefastfood(int idcommande, int idfastfood);
}
