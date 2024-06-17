package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.repositories.RoleRepository;
import uacd.master.sir.fast_food_api.services.RoleService;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

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
}
