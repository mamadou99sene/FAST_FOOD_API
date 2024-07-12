package uacd.master.sir.fast_food_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.dto.CommandeproduitRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandeproduitResponseDTO;
import uacd.master.sir.fast_food_api.services.CommandeproduitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/commandeproduits")
public class CommandeproduitController {
    private final CommandeproduitService commandeproduitService;
    @PostMapping
    public ResponseEntity<CommandeproduitResponseDTO> createCommandeproduit(@RequestBody CommandeproduitRequestDTO requestDTO) {
        CommandeproduitResponseDTO responseDTO = commandeproduitService.createCommandeproduit(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{idcommande}/{idproduit}")
    public ResponseEntity<CommandeproduitResponseDTO> getCommandeproduit(@PathVariable int idcommande, @PathVariable int idproduit) {
        CommandeproduitResponseDTO responseDTO = commandeproduitService.getCommandeproduit(idcommande, idproduit);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CommandeproduitResponseDTO>> getAllCommandeproduits() {
        List<CommandeproduitResponseDTO> responseDTOs = commandeproduitService.getAllCommandeproduits();
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/{idcommande}/{idproduit}")
    public ResponseEntity<CommandeproduitResponseDTO> updateCommandeproduit(
            @PathVariable int idcommande,
            @PathVariable int idproduit,
            @RequestBody CommandeproduitRequestDTO requestDTO) {
        CommandeproduitResponseDTO responseDTO = commandeproduitService.updateCommandeproduit(idcommande, idproduit, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{idcommande}/{idproduit}")
    public ResponseEntity<Void> deleteCommandeproduit(@PathVariable int idcommande, @PathVariable int idproduit) {
        commandeproduitService.deleteCommandeproduit(idcommande, idproduit);
        return ResponseEntity.noContent().build();
    }

}
