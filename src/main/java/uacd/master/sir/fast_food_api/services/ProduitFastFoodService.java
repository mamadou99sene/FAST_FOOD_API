package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.ProduitFastFoodDTO;

import java.util.List;
public interface ProduitFastFoodService {
    public List<ProduitFastFoodDTO> getProduitByIdFastFood(int idfastfood);
    ProduitFastFoodDTO saveProduitInFastFood(ProduitFastFoodDTO produitFastFoodDTO);
}
