package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacd.master.sir.fast_food_api.models.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository <Categorie, Integer>{

}
