package uacd.master.sir.fast_food_api.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uacd.master.sir.fast_food_api.models.Fastfood;
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
