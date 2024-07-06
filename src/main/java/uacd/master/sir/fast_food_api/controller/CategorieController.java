package uacd.master.sir.fast_food_api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.models.Categorie;
import uacd.master.sir.fast_food_api.services.CategorieService;

import java.util.List;

@RequestMapping("/api/categorie")
@AllArgsConstructor
public class CategorieController {

    private  CategorieService categorieService;

    @GetMapping
    ResponseEntity<List<Categorie>>getAllCategorie(){
        List<Categorie> categories = this.categorieService.getAllCategorie();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        Categorie categorie1= categorieService.saveCategorie(categorie);
        return ResponseEntity.ok(categorie1);
    }

    @GetMapping(path = "/{idCategorie}")
    ResponseEntity<Categorie> getCategorieById(@PathVariable int idCategorie)
    {
        Categorie categorie = this.categorieService.getCategorieById(idCategorie);
        if(categorie==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categorie,HttpStatus.OK);
    }

    @PostMapping("/{idCategorie}")
    public ResponseEntity<Boolean> deleteCategorie(@PathVariable int idCategorie) {
        Boolean isDeleted = categorieService.deleteCategorie(idCategorie);
        return ResponseEntity.ok(isDeleted);
    }

    @PutMapping("/{idCategorie}")
    public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorie ,@PathVariable int idCategorie) {
        Categorie newCategorie = categorieService.updateCategorie(categorie, idCategorie);
        return ResponseEntity.ok(newCategorie);
    }

}
