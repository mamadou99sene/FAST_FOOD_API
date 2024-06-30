package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.dto.RoleUtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.models.Roleutilisateur;
import uacd.master.sir.fast_food_api.models.Utilisateur;
import uacd.master.sir.fast_food_api.repositories.RoleRepository;
import uacd.master.sir.fast_food_api.repositories.RoleUtilisateurRepository;
import uacd.master.sir.fast_food_api.repositories.UtilisateurRepository;
import uacd.master.sir.fast_food_api.services.RoleUtilisateurService;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleUtilisateurImpl implements RoleUtilisateurService {

    private final RoleUtilisateurRepository roleUtilisateurRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;

    @Override
    public Roleutilisateur create(RoleUtilisateurRequestDTO requestDTO) {

        Utilisateur utilisateur = requestDTO.getUtilisateur();
        Role role = requestDTO.getRole();

        Roleutilisateur roleutilisateur = new Roleutilisateur();

        roleutilisateur.setRoleByIdrole(role);
        roleutilisateur.setUtilisateurByIdutilisateur(utilisateur);

        return roleUtilisateurRepository.save(roleutilisateur);
    }

    @Override
    public String delete(int id) {
        Roleutilisateur roleutilisateur = roleUtilisateurRepository.findRoleutilisateurById(id);

        roleUtilisateurRepository.delete(roleutilisateur);
        return "RoleUtilisateur deleted";
    }

    @Override
    public String deleteByUtilisateur(Utilisateur utilisateur) {
        Roleutilisateur roleutilisateur = roleUtilisateurRepository.findRoleutilisateurByUtilisateurByIdutilisateur(utilisateur);
        roleUtilisateurRepository.delete(roleutilisateur);
        return "RoleUtilisateur deleted";
    }

    @Override
    public Roleutilisateur update(int id) {
        return null;
    }

    @Override
    public List<Roleutilisateur> readAll() {
        return null;
    }

    @Override
    public Roleutilisateur readById(int id) {
        return null;
    }


}
