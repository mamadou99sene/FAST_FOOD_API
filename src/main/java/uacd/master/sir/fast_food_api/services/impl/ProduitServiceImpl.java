package uacd.master.sir.fast_food_api.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.DTO.ProduitRequestDTO;
import uacd.master.sir.fast_food_api.DTO.ProduitResponseDTO;
import uacd.master.sir.fast_food_api.Services.ProduitService;
import uacd.master.sir.fast_food_api.models.Produit;
import uacd.master.sir.fast_food_api.repositories.ProduitRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<ProduitResponseDTO> getAllProduits()
    {
        return produitRepository.
                findAll().
                stream().
                map(this::convertToDTO).
                collect(Collectors.toList());
    }
    public ProduitResponseDTO convertToDTO(Produit produit)
    {
        ProduitResponseDTO dto=new ProduitResponseDTO();
        dto.setIdproduit(produit.getIdproduit());
        dto.setIdCategorie(produit.getIdcategorie());
        dto.setNom(produit.getNom());
        dto.setPrix(produit.getPrix());
        dto.setDescription(produit.getDescription());
        dto.setImage(produit.getImage());
        return  dto;
    }
    public  Produit convertToEntity(ProduitRequestDTO produitDTO)
    {
        Produit produit=new Produit();
        produit.setIdcategorie(produitDTO.getIdcategorie());
        produit.setNom(produitDTO.getNom());
        produit.setDescription(produitDTO.getDescription());
        produit.setImage(produitDTO.getImage());
        produit.setPrix(produitDTO.getPrix());
        return produit;
    }

    @Override
    public ProduitResponseDTO getProduitById(int idProduit) {
        return produitRepository.
                findById(idProduit).
                map(this::convertToDTO).
                orElse(null);
    }

    @Override
    public ProduitResponseDTO saveProduit(ProduitRequestDTO produitDTO) {
        Produit produit=this.convertToEntity(produitDTO);
        produitRepository.save(produit);
        return convertToDTO(produit);
    }

    @Override
    public ProduitResponseDTO updateProduit(ProduitRequestDTO produitDTO, int idProduit) {
       Produit produit=produitRepository.findById(idProduit).get();
       produit.setPrix(produitDTO.getPrix());
       produit.setNom(produitDTO.getNom());
       produit.setDescription(produitDTO.getDescription());
       produitRepository.save(produit);
       return this.convertToDTO(produit);

    }

    @Override
    public boolean deleteProduit(int idProduit) {
        Produit produit=produitRepository.findById(idProduit).get();
       produitRepository.delete(produit);
       return true;
    }
}
