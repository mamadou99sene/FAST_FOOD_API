package uacd.master.sir.fast_food_api.controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    ResponseEntity <FastFoodResponseDTO> saveFastFood(@RequestBody FastFoodRequestDTO dto)
    {
        FastFoodResponseDTO fastFoodResponseDTO=fastFoodService.saveFastFood(dto);
        return new ResponseEntity<>(fastFoodResponseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/{idFastFood}")
    ResponseEntity<FastFoodResponseDTO> updateFastFood(@RequestBody FastFoodRequestDTO dto, @PathVariable int idFastFood)
    {
        FastFoodResponseDTO fastFoodResponseDTO=this.fastFoodService.updateFastFood(dto,idFastFood);
       if(fastFoodResponseDTO==null)
       {
           return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
       }
       return new ResponseEntity<>(fastFoodResponseDTO,HttpStatus.OK);
    }
    @GetMapping(path = "/{idFastFood}")
    ResponseEntity<FastFoodResponseDTO> getFastFoodById(@PathVariable int idFastFood)
    {
        FastFoodResponseDTO dto=this.fastFoodService.getfastFoodById(idFastFood);
        if(dto==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping(path = "/{idFastFood}")
    ResponseEntity<String> deleteFastFood(@PathVariable int idFastFood)
    {
        boolean isDeleted=this.fastFoodService.deleteFastFood(idFastFood);
        if(!isDeleted)
        {
            return new ResponseEntity<>(HttpStatus.GONE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path = "/search")
    ResponseEntity<List<FastFoodResponseDTO>> getAllFastFoodByName(@RequestParam("name") String nom)
    {
        List<FastFoodResponseDTO> fastfoods=this.fastFoodService.getFastFoodsByName(nom);
        return new ResponseEntity<>(fastfoods,HttpStatus.OK);
    }
}
