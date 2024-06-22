package uacd.master.sir.fast_food_api.services;

import org.springframework.http.MediaType;
import uacd.master.sir.fast_food_api.dto.ImageProduitRequestDTO;
import uacd.master.sir.fast_food_api.dto.ImageProduitResponseDTO;

import java.util.List;

public interface ImageProduitService {

//    List<ImageProduitResponseDTO> readImageProduct();

    void createImageProduitWithAllImageList(List<ImageProduitRequestDTO> imageProduitRequestDTOS);
//
//    ImageProductDTO updateImageProduct(ImageProductDTO imageProductDTO, Long id);

//    void deleteImageProduct(Long id);
//
//    ImageProductDTO getImageProductById(Long id) throws ImageProductNotFoundException;
//
    List<ImageProduitResponseDTO> findAllUrlByProduitId(Long produitId);
//
//    ImageProductDTO findFirstByProduct(Long productId) throws ProductNotFoundException;
//
//    List<ImageProductResponseDTO> getProductsWithImage() throws ProductNotFoundException;

    MediaType determineImageMediaType(String imageName);
}
