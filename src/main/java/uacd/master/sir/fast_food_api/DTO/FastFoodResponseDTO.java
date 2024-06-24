package uacd.master.sir.fast_food_api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class FastFoodResponseDTO {
    private int idfastfood;
        private int idutilisateur;
        private String nom;
        private String description;

        private String localisation;

}
