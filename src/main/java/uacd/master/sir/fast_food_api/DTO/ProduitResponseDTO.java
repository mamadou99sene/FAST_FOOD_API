package uacd.master.sir.fast_food_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitResponseDTO {
    private int idproduit;
    private int idCategorie;
    private String nom;
    private String description;
    private BigInteger prix;
    private String image;
}
