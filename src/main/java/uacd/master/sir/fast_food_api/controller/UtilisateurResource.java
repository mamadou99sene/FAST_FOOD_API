package uacd.master.sir.fast_food_api.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.dto.UtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.dto.UtilisateurResponseDTO;
import uacd.master.sir.fast_food_api.models.Utilisateur;
import uacd.master.sir.fast_food_api.repositories.UtilisateurRepository;
import uacd.master.sir.fast_food_api.services.UtilisateurService;
import uacd.master.sir.fast_food_api.services.impl.UtilisateurServiceImpl;
import uacd.master.sir.fast_food_api.utils.HttpResponse;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/utilisateur")
@CrossOrigin("*")
public class UtilisateurResource {

    private final UtilisateurService utilisateurService;

    @PostMapping
    public ResponseEntity<HttpResponse> create(@RequestBody UtilisateurRequestDTO utilisateur){

        UtilisateurResponseDTO newUser = utilisateurService.create(utilisateur);

        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("Utilisateur", newUser))
                        .message("Utilisateur created!")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<HttpResponse> confirmUserAccount(@RequestParam("token") String token){
        Boolean isSuccess = utilisateurService.verifyToken(token);

        return ResponseEntity.created(URI.create("")).body(

                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("success", isSuccess))
                        .message("Account verified!")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpResponse> update(@PathVariable int id, @RequestBody UtilisateurRequestDTO utilisateur) {
        UtilisateurResponseDTO updatedUser = utilisateurService.update(id, utilisateur);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("Utilisateur", updatedUser))
                        .message("Utilisateur modifié!")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> readById(@PathVariable int id) {
        UtilisateurResponseDTO utilisateur = utilisateurService.readById(id);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("Utilisateur", utilisateur))
                        .message("Utilisateur retourné!")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<HttpResponse> readAll() {
        List<UtilisateurResponseDTO> utilisateurs = utilisateurService.readAll();

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("Utilisateurs", utilisateurs))
                        .message("All utilisateurs retrieved!")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> delete(@PathVariable int id) {
        utilisateurService.delete(id);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .message("Utilisateur deleted!")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }



}
