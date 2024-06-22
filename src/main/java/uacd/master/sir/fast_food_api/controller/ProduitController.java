package uacd.master.sir.fast_food_api.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uacd.master.sir.fast_food_api.dto.ProduitRequestDTO;
import uacd.master.sir.fast_food_api.dto.ProduitResponseDTO;
import uacd.master.sir.fast_food_api.services.ImageProduitService;
import uacd.master.sir.fast_food_api.services.ProduitService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(value = "/api/produit",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ProduitController {

    private final ProduitService produitService;
    private final ImageProduitService imageProduitService;

    @GetMapping
    public ResponseEntity<List<ProduitResponseDTO>> getAllProduit() {
        List<ProduitResponseDTO> produitDTO=produitService.getAllProduits();
        return new ResponseEntity<>(produitDTO,HttpStatus.OK);

    }

    @GetMapping("/{idProduit}")
    public ResponseEntity<ProduitResponseDTO> getProduitById(@PathVariable int idProduit){
        ProduitResponseDTO produitDTO= produitService.getProduitById(idProduit);
        if(produitDTO==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produitDTO,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProduitResponseDTO> saveProduit(@RequestBody ProduitRequestDTO produitDTO){
        ProduitResponseDTO produitDTO1=produitService.saveProduit(produitDTO);
        return new ResponseEntity<>(produitDTO1,HttpStatus.CREATED);
    }

    @PutMapping("/{idProduit}")
    public ResponseEntity<ProduitResponseDTO> updateProduit(@RequestBody ProduitRequestDTO produitDTO, @PathVariable int idProduit){
       ProduitResponseDTO dto= produitService.updateProduit(produitDTO,idProduit);
       if(dto==null)
       {
           return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
       }
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }


    @DeleteMapping("/{idProduit}")
    public ResponseEntity<String> deleteProduit(@PathVariable int idProduit){
        boolean deleted=produitService.deleteProduit(idProduit);
        if(!deleted)
        {
            return new ResponseEntity(HttpStatus.GONE);
        }
        return new ResponseEntity(deleted,HttpStatus.OK);
    }

    // Endpoint pour ajouter une image à un produit
    @PostMapping("/upload/{produitId}/image")
    public ResponseEntity<ProduitResponseDTO> ajouterImageProduit(@PathVariable int produitId, @RequestParam("image") MultipartFile imageFile) {
        ProduitResponseDTO produit = produitService.ajouterImageProduit(produitId, imageFile);
        return ResponseEntity.ok(produit);
    }

    // Endpoint pour ajouter plusieurs images à un produit
    @PostMapping("/upload/{produitId}/images")
    public ResponseEntity<ProduitResponseDTO> ajouterImagesProduit(@PathVariable int produitId, @RequestParam("images") List<MultipartFile> imageFiles) {
        ProduitResponseDTO produit = produitService.ajouterImagesProduit(produitId, imageFiles);
        return ResponseEntity.ok(produit);
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        Resource resource = new ClassPathResource("static/images/" + imageName);

        // Déterminez le type de contenu en fonction de l'extension du fichier
        MediaType mediaType = imageProduitService.determineImageMediaType(imageName);

        byte[] imageBytes = Files.readAllBytes(Path.of(resource.getURI()));

        return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
    }
}
