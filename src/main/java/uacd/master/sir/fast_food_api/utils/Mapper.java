package uacd.master.sir.fast_food_api.utils;

import uacd.master.sir.fast_food_api.dto.RoleResponseDTO;
import uacd.master.sir.fast_food_api.dto.RoleUtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.dto.UtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.dto.UtilisateurResponseDTO;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.models.Roleutilisateur;
import uacd.master.sir.fast_food_api.models.Utilisateur;

public class Mapper {

    public static UtilisateurResponseDTO mapToUtilisateurResponse(Utilisateur utilisateur, UtilisateurResponseDTO responseDTO){

        responseDTO.setId(utilisateur.getIdutilisateur());
        responseDTO.setPrenom(utilisateur.getPrenom());
        responseDTO.setNom(utilisateur.getNom());
        responseDTO.setEmail(utilisateur.getEmail());

        return responseDTO;
    }

    public static Utilisateur mapToEntityUtilisateur(Utilisateur utilisateur, UtilisateurRequestDTO requestDTO){

        utilisateur.setPrenom(requestDTO.getPrenom());
        utilisateur.setNom(requestDTO.getNom());
        utilisateur.setEmail(requestDTO.getEmail());
        utilisateur.setPassword(requestDTO.getPassword());

        return utilisateur;
    }

    public static Roleutilisateur mapToEntityRoleutilisateur(Roleutilisateur roleutilisateur, RoleUtilisateurRequestDTO requestDTO){

        roleutilisateur.setUtilisateurByIdutilisateur(requestDTO.getUtilisateur());
        roleutilisateur.setRoleByIdrole(requestDTO.getRole());

        return roleutilisateur;
    }

    public static RoleResponseDTO mapToRoleResponse(Role role, RoleResponseDTO responseDTO){

        responseDTO.setId(role.getIdrole());
        responseDTO.setRole(role.getRole());
        responseDTO.setDescription(role.getDescription());

        return responseDTO;
    }
}
