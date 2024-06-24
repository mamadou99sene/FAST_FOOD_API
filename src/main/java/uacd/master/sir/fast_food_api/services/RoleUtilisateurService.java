package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.RoleUtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.models.Roleutilisateur;
import uacd.master.sir.fast_food_api.models.Utilisateur;

import java.util.List;

public interface RoleUtilisateurService {

    public Roleutilisateur create(RoleUtilisateurRequestDTO requestDTO);
    public String deleteByUtilisateur(Utilisateur utilisateur);
    public String delete(int id);
    public Roleutilisateur update(int id);
    public List<Roleutilisateur> readAll();
    public Roleutilisateur readById(int id);
}
