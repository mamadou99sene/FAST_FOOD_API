package uacd.master.sir.fast_food_api.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uacd.master.sir.fast_food_api.models.Produit;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProduitFastFoodDTO {
    private int idproduit;
    private int idfastfood;
    private Produit produitByIdproduit;
}
