package uacd.master.sir.fast_food_api.services;

import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.dto.ProduitFastFoodDTO;
import uacd.master.sir.fast_food_api.dto.ProduitResponseDTO;

import java.util.List;
public interface ProduitFastFoodService {
    public List<ProduitResponseDTO> getProduitByIdFastFood(int idfastfood);
    ProduitFastFoodDTO saveProduitInFastFood(ProduitFastFoodDTO produitFastFoodDTO);
}
