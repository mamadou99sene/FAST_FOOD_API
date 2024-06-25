package uacd.master.sir.fast_food_api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UtilisateurRequestDTO {

    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String type;
}
