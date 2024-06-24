package uacd.master.sir.fast_food_api.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.services.RoleService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/role")
public class RoleResource {

    private final RoleService roleService;

    @PostMapping
    public Role create(@RequestBody Role role){
        return roleService.create(role);
    }

}
