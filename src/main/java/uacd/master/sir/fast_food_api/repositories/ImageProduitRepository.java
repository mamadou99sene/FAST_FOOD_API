package uacd.master.sir.fast_food_api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacd.master.sir.fast_food_api.models.ImageProduit;
import uacd.master.sir.fast_food_api.models.Produit;

import java.util.List;

@Repository
public interface ImageProduitRepository extends JpaRepository<ImageProduit, Integer> {
    List<ImageProduit> findImageProduitsByProduit(Produit produit);
    ImageProduit findFirstByProduit(Produit produit);
}
