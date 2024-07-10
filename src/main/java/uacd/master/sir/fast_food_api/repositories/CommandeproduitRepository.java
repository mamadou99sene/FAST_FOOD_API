package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacd.master.sir.fast_food_api.models.Commandefastfood;
import uacd.master.sir.fast_food_api.models.Commandeproduit;
import uacd.master.sir.fast_food_api.models.CommandeproduitPK;

import java.util.List;

@Repository
public interface CommandeproduitRepository extends JpaRepository<Commandeproduit, CommandeproduitPK> {
    void deleteByIdcommande(int idcommande);
    List<Commandeproduit> findByIdcommande(int idcommande);
}
