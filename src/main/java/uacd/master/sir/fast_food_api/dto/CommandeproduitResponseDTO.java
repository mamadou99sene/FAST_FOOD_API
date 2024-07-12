package uacd.master.sir.fast_food_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandeproduitResponseDTO {
    private int idcommande;
    private int idproduit;
   // private ProduitResponseDTO produitByIdProduit;
}
