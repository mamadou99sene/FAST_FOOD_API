package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.DTO.FastFoodRequestDTO;
import uacd.master.sir.fast_food_api.DTO.FastFoodResponseDTO;
import uacd.master.sir.fast_food_api.models.Fastfood;

import java.util.List;

public interface FastFoodService {
    List<FastFoodResponseDTO> getAllFastFood();
    FastFoodResponseDTO getfastFoodById(int idFastFood);
    FastFoodResponseDTO saveFastFood(FastFoodRequestDTO fastFoodRequestDTO);
    FastFoodResponseDTO updateFastFood(FastFoodRequestDTO fastFoodRequestDTO, int idFastFood);
    boolean deleteFastFood(int idFastFood);
    List<FastFoodResponseDTO> getFastFoodsByName(String nom);
}
