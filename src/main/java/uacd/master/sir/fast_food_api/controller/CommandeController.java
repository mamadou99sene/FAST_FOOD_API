package uacd.master.sir.fast_food_api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.dto.CommandeRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandeResponseDTO;
import uacd.master.sir.fast_food_api.services.CommandeService;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/commandes")
public class CommandeController {
    private final CommandeService commandeService;
    @PostMapping
    public ResponseEntity<CommandeResponseDTO> createCommande(@RequestBody CommandeRequestDTO requestDTO) {
        System.out.println(requestDTO.getIdutilisateur());
        System.out.println(requestDTO.getFastfoods());
        CommandeResponseDTO responseDTO = commandeService.createCommande(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeResponseDTO> getCommande(@PathVariable int id) {
        CommandeResponseDTO responseDTO = commandeService.getCommande(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CommandeResponseDTO>> getAllCommandes() {
        List<CommandeResponseDTO> responseDTOs = commandeService.getAllCommandes();
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeResponseDTO> updateCommande(@PathVariable int id, @RequestBody CommandeRequestDTO requestDTO) {
        CommandeResponseDTO responseDTO = commandeService.updateCommande(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable int id) {
        commandeService.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}
