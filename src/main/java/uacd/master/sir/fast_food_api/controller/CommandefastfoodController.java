package uacd.master.sir.fast_food_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.dto.CommandefastfoodRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandefastfoodResponseDTO;
import uacd.master.sir.fast_food_api.services.CommandefastfoodService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/commandefastfoods")
public class CommandefastfoodController {

    private final CommandefastfoodService commandefastfoodService;

    @PostMapping
    public ResponseEntity<CommandefastfoodResponseDTO> createCommandefastfood(@RequestBody CommandefastfoodRequestDTO commandefastfoodRequestDTO) {
        CommandefastfoodResponseDTO responseDTO = commandefastfoodService.createCommandefastfood(commandefastfoodRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{idcommande}/{idfastfood}")
    public ResponseEntity<CommandefastfoodResponseDTO> getCommandefastfoodById(@PathVariable int idcommande, @PathVariable int idfastfood) {
        CommandefastfoodResponseDTO responseDTO = commandefastfoodService.getCommandefastfoodById(idcommande, idfastfood);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CommandefastfoodResponseDTO>> getAllCommandefastfoods() {
        List<CommandefastfoodResponseDTO> responseDTOs = commandefastfoodService.getAllCommandefastfoods();
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/{idcommande}/{idfastfood}")
    public ResponseEntity<CommandefastfoodResponseDTO> updateCommandefastfood(@PathVariable int idcommande, @PathVariable int idfastfood, @RequestBody CommandefastfoodRequestDTO commandefastfoodRequestDTO) {
        CommandefastfoodResponseDTO responseDTO = commandefastfoodService.updateCommandefastfood(idcommande, idfastfood, commandefastfoodRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{idcommande}/{idfastfood}")
    public ResponseEntity<Void> deleteCommandefastfood(@PathVariable int idcommande, @PathVariable int idfastfood) {
        commandefastfoodService.deleteCommandefastfood(idcommande, idfastfood);
        return ResponseEntity.noContent().build();
}
}
