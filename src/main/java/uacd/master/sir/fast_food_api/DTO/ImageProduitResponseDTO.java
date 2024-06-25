package uacd.master.sir.fast_food_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uacd.master.sir.fast_food_api.models.Produit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageProduitResponseDTO {

    private Produit produit;
    private String url;
}
