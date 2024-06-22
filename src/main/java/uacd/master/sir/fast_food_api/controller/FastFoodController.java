package uacd.master.sir.fast_food_api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.dto.FastFoodRequestDTO;
import uacd.master.sir.fast_food_api.dto.FastFoodResponseDTO;
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
    ResponseEntity <FastFoodResponseDTO> saveFastFood(@RequestBody FastFoodRequestDTO dto)
    {
        FastFoodResponseDTO fastFoodResponseDTO=fastFoodService.saveFastFood(dto);
        return new ResponseEntity<>(fastFoodResponseDTO, HttpStatus.CREATED);
    }
}
