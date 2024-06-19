package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uacd.master.sir.fast_food_api.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findRoleByIdrole(int id);
}
