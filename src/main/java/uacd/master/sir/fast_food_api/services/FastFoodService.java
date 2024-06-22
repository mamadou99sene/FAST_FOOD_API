package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.FastFoodRequestDTO;
import uacd.master.sir.fast_food_api.dto.FastFoodResponseDTO;
import uacd.master.sir.fast_food_api.models.Fastfood;

import java.util.List;

public interface FastFoodService {
    List<FastFoodResponseDTO> getAllFastFood();
    FastFoodResponseDTO getfastFoodById(int idFastFood);
    FastFoodResponseDTO saveFastFood(FastFoodRequestDTO fastFoodRequestDTO);
    FastFoodResponseDTO updateFastFood(FastFoodRequestDTO fastFoodRequestDTO, int idFastFood);
    boolean deleteFastFood(FastFoodRequestDTO fastFoodRequestDTO);
    List<FastFoodResponseDTO> getFastFoodsByName();
    FastFoodResponseDTO convertToDTO(Fastfood fastfood);
    Fastfood convertToEntity(FastFoodRequestDTO fastFoodRequestDTO);
}
