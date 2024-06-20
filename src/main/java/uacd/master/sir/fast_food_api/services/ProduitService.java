package uacd.master.sir.fast_food_api.Services;

import uacd.master.sir.fast_food_api.DTO.ProduitRequestDTO;
import uacd.master.sir.fast_food_api.DTO.ProduitResponseDTO;

import java.util.List;

public interface ProduitService {
    List<ProduitResponseDTO> getAllProduits();
    ProduitResponseDTO getProduitById(int idProdduit);
    ProduitResponseDTO saveProduit(ProduitRequestDTO produitDTO);
    ProduitResponseDTO updateProduit(ProduitRequestDTO produitDTO, int idProduit);
    boolean deleteProduit(int idProduit);

}
