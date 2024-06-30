package uacd.master.sir.fast_food_api.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.dto.RoleResponseDTO;
import uacd.master.sir.fast_food_api.models.Role;
import uacd.master.sir.fast_food_api.services.RoleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/role")
public class RoleResource {

    private final RoleService roleService;

    @PostMapping
    public Role create(@RequestBody Role role){
        return roleService.create(role);
    }

    @GetMapping("/utilisateur/{idutilisateur}")
    public ResponseEntity<List<RoleResponseDTO>> getRolesByUtilisateurId(@PathVariable int idutilisateur) {
        List<RoleResponseDTO> roles = roleService.getRolesByUtilisateurId(idutilisateur);
        return ResponseEntity.ok(roles);
    }
}
