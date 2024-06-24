package uacd.master.sir.fast_food_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
@Getter
@Setter
public class ProduitRequestDTO {
    private int idcategorie;
    private String nom;
    private String description;
    private BigInteger prix;
    private String image;
}
