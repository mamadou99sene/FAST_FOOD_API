package uacd.master.sir.fast_food_api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.dto.ProduitFastFoodDTO;
import uacd.master.sir.fast_food_api.dto.ProduitResponseDTO;
import uacd.master.sir.fast_food_api.services.ProduitFastFoodService;

import java.util.List;

@RestController
@RequestMapping("/api/fastfood/produits")
@AllArgsConstructor
public class ProduitFastFoodController {
    private ProduitFastFoodService produitFastFoodService;
    @GetMapping("/{idFastFood}")
    public ResponseEntity<List<ProduitResponseDTO>> getAllProductsByIdFastFood(@PathVariable int idFastFood)
    {
        List<ProduitResponseDTO> allProductByidfastfood=this.produitFastFoodService.getProduitByIdFastFood(idFastFood);
        if(allProductByidfastfood==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allProductByidfastfood,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity <ProduitFastFoodDTO> saveProduitFastFood(@RequestBody ProduitFastFoodDTO dto)
    {
       return new ResponseEntity<>(
               this.produitFastFoodService.
                       saveProduitInFastFood(dto),HttpStatus.OK);
    }
}
