package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.dto.RoleResponseDTO;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.models.Roleutilisateur;
import uacd.master.sir.fast_food_api.repositories.RoleRepository;
import uacd.master.sir.fast_food_api.repositories.RoleUtilisateurRepository;
import uacd.master.sir.fast_food_api.services.RoleService;
import uacd.master.sir.fast_food_api.utils.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private RoleUtilisateurRepository roleutilisateurRepository;


    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public String delete(int id) {

        Role Role = roleRepository.findRoleByIdrole(id);
        roleRepository.delete(Role);

        return "Role deleted with success !";
    }

    @Override
    public Role update(int id) {
//        return RoleRepository.updateRoleByIdRole(id);

        return null;
    }

    @Override
    public List<Role> readAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role readById(int id) {
        return null;
    }

    @Override
    public List<RoleResponseDTO> getRolesByUtilisateurId(int idutilisateur) {
        List<Roleutilisateur> roleutilisateurs = roleutilisateurRepository.findByUtilisateurByIdutilisateur_Idutilisateur(idutilisateur);
        return roleutilisateurs.stream()
                .map(roleutilisateur -> Mapper.mapToRoleResponse(roleutilisateur.getRoleByIdrole(), new RoleResponseDTO()))
                .collect(Collectors.toList());
    }
}
