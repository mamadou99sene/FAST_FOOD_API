package uacd.master.sir.fast_food_api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uacd.master.sir.fast_food_api.DTO.FastFoodRequestDTO;
import uacd.master.sir.fast_food_api.DTO.FastFoodResponseDTO;
import uacd.master.sir.fast_food_api.services.FastFoodService;

import java.util.List;

@RestController
@RequestMapping( path = "/api/fastfood")
@AllArgsConstructor
public class FastFoodController {
    final private FastFoodService fastFoodService;
    @GetMapping
    ResponseEntity<List<FastFoodResponseDTO>> getAllfastFood()
    {
        List<FastFoodResponseDTO> fastfoods=fastFoodService.getAllFastFood();
       return new ResponseEntity<>(fastfoods, HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity <FastFoodResponseDTO> saveFastFood(FastFoodRequestDTO dto)
    {
        FastFoodResponseDTO fastFoodResponseDTO=fastFoodService.saveFastFood(dto);
        return new ResponseEntity<>(fastFoodResponseDTO, HttpStatus.CREATED);
    }
}
