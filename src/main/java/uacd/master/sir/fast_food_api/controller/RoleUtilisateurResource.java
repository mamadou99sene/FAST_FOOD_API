package uacd.master.sir.fast_food_api.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.dto.RoleUtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.models.Roleutilisateur;
import uacd.master.sir.fast_food_api.services.RoleService;
import uacd.master.sir.fast_food_api.services.RoleUtilisateurService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roleUtilisateur")
public class RoleUtilisateurResource {

    private final RoleUtilisateurService roleUtilisateurService;

    @PostMapping
    public Roleutilisateur create(@RequestBody RoleUtilisateurRequestDTO requestDTO){
        return roleUtilisateurService.create(requestDTO);
    }

}
