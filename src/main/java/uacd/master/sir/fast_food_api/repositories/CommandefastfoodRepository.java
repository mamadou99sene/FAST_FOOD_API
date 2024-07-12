package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacd.master.sir.fast_food_api.models.Commandefastfood;
import uacd.master.sir.fast_food_api.models.CommandefastfoodPK;

import java.util.List;

@Repository
public interface CommandefastfoodRepository extends JpaRepository <Commandefastfood, CommandefastfoodPK> {
    void deleteByIdcommande(int idcommande);
    List<Commandefastfood> findByIdcommande(int idcommande);

    List<Commandefastfood> findByIdfastfood(int idfastfood);
}
