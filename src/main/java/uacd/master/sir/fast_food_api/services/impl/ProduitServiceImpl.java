package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uacd.master.sir.fast_food_api.dto.ProduitRequestDTO;
import uacd.master.sir.fast_food_api.dto.ProduitResponseDTO;
import uacd.master.sir.fast_food_api.models.ImageProduit;
import uacd.master.sir.fast_food_api.repositories.ImageProduitRepository;
import uacd.master.sir.fast_food_api.services.ProduitService;
import uacd.master.sir.fast_food_api.models.Produit;
import uacd.master.sir.fast_food_api.repositories.ProduitRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    private final ImageProduitRepository imageProduitRepository;

    // Répertoire de téléchargement des images, défini dans application.properties
    @Value("${image.upload.dir}")
    private String imageUploadDir;

    // Méthode pour ajouter une image à un produit
    public ProduitResponseDTO ajouterImageProduit(int produitId, MultipartFile imageFile) {

        // Récupération du type de contenu du fichier
        String contentType = imageFile.getContentType();

        // Vérification du type de contenu du fichier
        if (contentType == null || (!contentType.equals("image/png") &&
                !contentType.equals("image/jpeg") &&
                !contentType.equals("image/jpg") &&
                !contentType.equals("image/gif"))) {
            // Si le type de contenu n'est pas supporté, une exception est levée
            throw new RuntimeException("Type de fichier non supporté. Veuillez télécharger une image PNG, JPEG, JPG ou GIF.");
        }

        Optional<Produit> produitOpt = produitRepository.findById(produitId);

        if (produitOpt.isPresent()) {

            Produit produit = produitOpt.get();

            // Génération d'un nom unique pour le fichier d'image
            String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
//            File file = new File(imageUploadDir + fileName);

            try {
                // Sauvegarde du fichier d'image localement
//                imageFile.transferTo(file);

                // Enregistrez le fichier dans le dossier "images"
                Path imagePath = Path.of(imageUploadDir + fileName);
                Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

                ImageProduit imageProduit = new ImageProduit();
                imageProduit.setUrl(fileName);// URL relative pour accéder à l'image
                imageProduit.setProduit(produit);
                imageProduitRepository.save(imageProduit); // Sauvegarde de l'objet ImageProduit dans la base de données

                return convertToDTO(produit);

            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de l'enregistrement de l'image", e);
            }
        } else {
            throw new RuntimeException("Produit non trouvé");
        }
    }

    // Méthode pour ajouter plusieurs images à un produit
    public ProduitResponseDTO ajouterImagesProduit(int produitId, List<MultipartFile> imageFiles) {

        Optional<Produit> produitOpt = produitRepository.findById(produitId);
        if (produitOpt.isPresent()) {
            Produit produit = produitOpt.get();
            for (MultipartFile imageFile : imageFiles) {

                // Récupération du type de contenu du fichier
                String contentType = imageFile.getContentType();

                // Vérification du type de contenu du fichier
                if (contentType == null || (!contentType.equals("image/png") &&
                        !contentType.equals("image/jpeg") &&
                        !contentType.equals("image/jpg") &&
                        !contentType.equals("image/gif"))) {
                    // Si le type de contenu n'est pas supporté, une exception est levée on ne fait rien

                }else {
                    String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();

                    try {
                        // Enregistrez le fichier dans le dossier "images"
                        Path imagePath = Path.of(imageUploadDir + fileName);
                        Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

                        ImageProduit imageProduit = new ImageProduit();
                        imageProduit.setUrl(fileName);
                        imageProduit.setProduit(produit);
                        imageProduitRepository.save(imageProduit);
                    } catch (IOException e) {
                        throw new RuntimeException("Erreur lors de l'enregistrement de l'image", e);
                    }
                }


            }
            return convertToDTO(produit);
        } else {
            throw new RuntimeException("Produit non trouvé");
        }
    }

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
        ProduitResponseDTO dto = new ProduitResponseDTO();

        dto.setIdproduit(produit.getIdproduit());
        dto.setIdCategorie(produit.getIdcategorie());
        dto.setNom(produit.getNom());
        dto.setPrix(produit.getPrix());
        dto.setDescription(produit.getDescription());
//        dto.setImage(produit.getImage());
        return  dto;
    }
    public  Produit convertToEntity(ProduitRequestDTO produitDTO)
    {
        Produit produit=new Produit();
        produit.setIdcategorie(produitDTO.getIdcategorie());
        produit.setNom(produitDTO.getNom());
        produit.setDescription(produitDTO.getDescription());
//        produit.setImage(produitDTO.getImage());
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

        Produit produit = this.convertToEntity(produitDTO);
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
