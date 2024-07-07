package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uacd.master.sir.fast_food_api.dto.ProduitFastFoodDTO;
import uacd.master.sir.fast_food_api.dto.ProduitResponseDTO;
import uacd.master.sir.fast_food_api.models.Produit;
import uacd.master.sir.fast_food_api.models.Produitfastfood;
import uacd.master.sir.fast_food_api.models.ProduitfastfoodPK;
import uacd.master.sir.fast_food_api.repositories.FastFoodRepository;
import uacd.master.sir.fast_food_api.repositories.ProduitFastFoodRepository;
import uacd.master.sir.fast_food_api.repositories.ProduitRepository;
import uacd.master.sir.fast_food_api.services.ProduitFastFoodService;
import uacd.master.sir.fast_food_api.utils.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service

public class ProduitFastFoodServiceImpl implements ProduitFastFoodService {
    private ProduitFastFoodRepository produitFastFoodRepository;
    private ProduitRepository produitRepository;
    private FastFoodRepository fastFoodRepository;
    @Override
    public List<ProduitResponseDTO> getProduitByIdFastFood(int idfastfood) {
        return this.produitFastFoodRepository
                .findAllByIdfastfood(idfastfood)
                .stream()
                .map(this::convertToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProduitFastFoodDTO saveProduitInFastFood(ProduitFastFoodDTO produitFastFoodDTO) {
        try {
//            Produit produit = mapToProduit(produitFastFoodDTO);
//            Produit savedProduit= produitRepository.save(produit);
            ProduitfastfoodPK pk=new ProduitfastfoodPK();
            pk.setIdproduit(produitFastFoodDTO.getIdproduit());
            pk.setIdfastfood(produitFastFoodDTO.getIdfastfood());
            Produitfastfood produitfastfood=new Produitfastfood();
            produitfastfood.setIdproduit(pk.getIdproduit());
//            produitfastfood.setProduitByIdproduit(produitFastFoodRepository.findById(pk).get().getProduitByIdproduit());
            produitfastfood.setIdfastfood(pk.getIdfastfood());
//            produitfastfood.setFastfoodByIdfastfood(produitFastFoodRepository.findById(pk).get().getFastfoodByIdfastfood());
            Produitfastfood p= this.produitFastFoodRepository.save(produitfastfood);
            return this.convertToDTO(p);
        }
        catch (Exception e)
        {
            System.out.print("Exception generée "+e.getMessage());
            System.out.print("\n\t\t\tPile: \n ");
            e.printStackTrace();
        }
       return null;
    }

    public ProduitFastFoodDTO convertToProductFastFoodDTO(Produitfastfood produitfastfood){
        ProduitFastFoodDTO dto=new ProduitFastFoodDTO();
        dto.setIdproduit(produitfastfood.getIdproduit());
        dto.setIdfastfood(produitfastfood.getIdfastfood());
        return dto;
    }

    public ProduitResponseDTO convertToProductResponseDTO(Produitfastfood produitfastfood)
    {
//        ProduitFastFoodDTO dto=new ProduitFastFoodDTO();
//        dto.setIdproduit(produitfastfood.getIdproduit());
//        dto.setIdfastfood(produitfastfood.getIdfastfood());
//        dto.setProduitByIdproduit(produitfastfood.getProduitByIdproduit());

        Produit dto = produitRepository.findProduitByIdproduit(produitfastfood.getIdproduit());
        return Mapper.convertToDTO(dto);
    }
    public Produitfastfood convertToEntity(ProduitFastFoodDTO dto)
    {   Produitfastfood produitfastfood = new Produitfastfood();
        produitfastfood.setIdfastfood(dto.getIdfastfood());
        ProduitfastfoodPK pk=new ProduitfastfoodPK();
        pk.setIdfastfood(dto.getIdfastfood());
//        produitfastfood.setFastfoodByIdfastfood(
//                produitFastFoodRepository.findById(pk).get().getFastfoodByIdfastfood()
//                       );
              return produitfastfood;
    }
//    public Produit mapToProduit(ProduitFastFoodDTO dto)
//    {
//        Produit produit=new Produit();
//        produit.setIdcategorie(dto.getProduitByIdproduit().getIdcategorie());
//        produit.setNom(dto.getProduitByIdproduit().getNom());
//        produit.setDescription(dto.getProduitByIdproduit().getDescription());
//        produit.setPrix(dto.getProduitByIdproduit().getPrix());
//        return produit;
//    }
}
