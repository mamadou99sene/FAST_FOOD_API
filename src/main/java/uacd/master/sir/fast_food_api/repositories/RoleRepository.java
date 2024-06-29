package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uacd.master.sir.fast_food_api.models.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByIdrole(int id);

    List<Role> findRolesByIdroleIn(List<Integer> list);
}
