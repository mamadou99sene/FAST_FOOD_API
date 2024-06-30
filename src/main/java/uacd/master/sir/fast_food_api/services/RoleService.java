package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.RoleResponseDTO;
import uacd.master.sir.fast_food_api.models.Role;

import java.util.List;

public interface RoleService {

    public Role create(Role role);
    public String delete(int id);
    public Role update(int id);
    public List<Role> readAll();
    public Role readById(int id);
    List<RoleResponseDTO> getRolesByUtilisateurId(int idutilisateur);
}
