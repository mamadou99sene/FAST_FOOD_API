package uacd.master.sir.fast_food_api.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.DTO.CommandeRequestDTO;
import uacd.master.sir.fast_food_api.DTO.CommandeResponseDTO;
import uacd.master.sir.fast_food_api.services.CommandeService;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/commandes")
public class CommandeController {
    private final CommandeService commandeService;
    @PostMapping
    public ResponseEntity<CommandeResponseDTO> createCommande(@RequestBody CommandeRequestDTO commandeRequestDTO) {
        CommandeResponseDTO responseDTO = commandeService.createCommande(commandeRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommandeResponseDTO> getCommandeById(@PathVariable int id) {
        CommandeResponseDTO responseDTO = commandeService.getCommandeById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CommandeResponseDTO>> getAllCommandes() {
        List<CommandeResponseDTO> responseDTOList = commandeService.getAllCommandes();
        return ResponseEntity.ok(responseDTOList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeResponseDTO> updateCommande(@PathVariable int id, @RequestBody CommandeRequestDTO commandeRequestDTO) {
        CommandeResponseDTO responseDTO = commandeService.updateCommande(id, commandeRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable int id) {
        commandeService.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}
