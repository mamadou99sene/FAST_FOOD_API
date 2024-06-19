package uacd.master.sir.fast_food_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uacd.master.sir.fast_food_api.DTO.ProduitRequestDTO;
import uacd.master.sir.fast_food_api.DTO.ProduitResponseDTO;
import uacd.master.sir.fast_food_api.Services.impl.ProduitServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/produit",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProduitController {
    @Autowired
    private ProduitServiceImpl produitService;
    @GetMapping
    public ResponseEntity<List<ProduitResponseDTO>> getAllProduit()
    {
        List<ProduitResponseDTO> produitDTO=produitService.getAllProduits();
        return new ResponseEntity<>(produitDTO,HttpStatus.OK);

    }
    @GetMapping("/{idProduit}")
    public ResponseEntity<ProduitResponseDTO> getProduitById(@PathVariable int idProduit)
    {
        ProduitResponseDTO produitDTO= produitService.getProduitById(idProduit);
        if(produitDTO==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produitDTO,HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<ProduitResponseDTO> saveProduit(@RequestBody ProduitRequestDTO produitDTO)
    {
        ProduitResponseDTO produitDTO1=produitService.saveProduit(produitDTO);
        return new ResponseEntity<>(produitDTO1,HttpStatus.CREATED);
    }
    @PutMapping("/{idProduit}")
    public ResponseEntity<ProduitResponseDTO> updateProduit(@RequestBody ProduitRequestDTO produitDTO, @PathVariable int idProduit)
    {
       ProduitResponseDTO dto= produitService.updateProduit(produitDTO,idProduit);
       if(dto==null)
       {
           return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
       }
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/{idProduit}")
    public ResponseEntity<String> deleteProduit(@PathVariable int idProduit)
    {
        boolean deleted=produitService.deleteProduit(idProduit);
        if(!deleted)
        {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(deleted,HttpStatus.GONE);
    }
}
