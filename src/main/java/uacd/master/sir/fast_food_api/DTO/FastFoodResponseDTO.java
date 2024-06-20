package uacd.master.sir.fast_food_api.DTO;

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
