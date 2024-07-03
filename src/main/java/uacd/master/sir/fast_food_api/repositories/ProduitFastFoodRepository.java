package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacd.master.sir.fast_food_api.models.Produitfastfood;
import uacd.master.sir.fast_food_api.models.ProduitfastfoodPK;

import java.util.List;

@Repository
public interface ProduitFastFoodRepository extends JpaRepository<Produitfastfood, ProduitfastfoodPK> {
    List<Produitfastfood> findAllByFastfoodByIdfastfood_Idfastfood(int idfastfood);
}
