package uacd.master.sir.fast_food_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageProduitRequestDTO {

    private int id;
    private String url;
    private int produit;
}
