package uacd.master.sir.fast_food_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.models.Utilisateur;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUtilisateurRequestDTO {

    private Role role;
    private Utilisateur utilisateur;
}
