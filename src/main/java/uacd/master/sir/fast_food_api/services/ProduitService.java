package uacd.master.sir.fast_food_api.services;

import org.springframework.web.multipart.MultipartFile;
import uacd.master.sir.fast_food_api.dto.ProduitRequestDTO;
import uacd.master.sir.fast_food_api.dto.ProduitResponseDTO;
import uacd.master.sir.fast_food_api.models.Produit;

import java.util.List;

public interface ProduitService {

    List<ProduitResponseDTO> getAllProduits();
    ProduitResponseDTO getProduitById(int idProdduit);
    ProduitResponseDTO saveProduit(ProduitRequestDTO produitDTO);
    ProduitResponseDTO updateProduit(ProduitRequestDTO produitDTO, int idProduit);
    boolean deleteProduit(int idProduit);
    Produit convertToEntity(ProduitRequestDTO produitDTO);
    ProduitResponseDTO convertToDTO(Produit produit);

    ProduitResponseDTO ajouterImageProduit(int produitId, MultipartFile imageFile);
    ProduitResponseDTO ajouterImagesProduit(int produitId, List<MultipartFile> imageFiles);

}
