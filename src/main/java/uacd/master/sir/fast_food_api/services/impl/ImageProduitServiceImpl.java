package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
//import uacd.master.sir.fast_food_api.dto.ImageProduitRequestDTO;
//import uacd.master.sir.fast_food_api.dto.ImageProduitResponseDTO;
import uacd.master.sir.fast_food_api.repositories.ImageProduitRepository;
import uacd.master.sir.fast_food_api.services.ImageProduitService;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageProduitServiceImpl implements ImageProduitService {

    private final ImageProduitRepository imageProduitRepository;

//    @Override
//    public void createImageProduitWithAllImageList(List<ImageProduitRequestDTO> imageProduitRequestDTOS) {
//
//    }

//    @Override
//    public List<ImageProduitResponseDTO> findAllUrlByProduitId(Long produitId) {
//        return null;
//    }

    @Override
    public MediaType determineImageMediaType(String imageName) {
        if (imageName.toLowerCase().endsWith(".jpg") || imageName.toLowerCase().endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else if (imageName.toLowerCase().endsWith(".png")) {
            return MediaType.IMAGE_PNG;
        } else if (imageName.toLowerCase().endsWith(".gif")) {
            return MediaType.IMAGE_GIF;
        }
        // Par défaut, renvoyer IMAGE_JPEG si le type n'est pas reconnu
        return MediaType.IMAGE_JPEG;
    }
}
