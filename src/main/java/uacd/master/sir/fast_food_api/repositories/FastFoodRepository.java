package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uacd.master.sir.fast_food_api.models.Fastfood;

import java.util.List;

@Repository
public interface FastFoodRepository extends JpaRepository<Fastfood, Integer> {
    @Query("SELECT f from Fastfood  f where LOWER(f.nom) LIKE LOWER(CONCAT('%',:name, '%') ) ")
    List<Fastfood> findFastfoodByNomContainingIgnoreCase(@Param("name") String nom);
}

