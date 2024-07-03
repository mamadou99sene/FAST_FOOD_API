gitpackage uacd.master.sir.fast_food_api.services;

import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.DTO.ProduitFastFoodDTO;

import java.util.List;
public interface ProduitFastFoodService {
    public List<ProduitFastFoodDTO> getProduitByIdFastFood(int idfastfood);
    ProduitFastFoodDTO saveProduitInFastFood(ProduitFastFoodDTO produitFastFoodDTO);
}
