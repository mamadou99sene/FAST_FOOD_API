package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacd.master.sir.fast_food_api.models.Commandefastfood;
import uacd.master.sir.fast_food_api.models.CommandefastfoodPK;

@Repository
public interface CommandefastfoodRepository extends JpaRepository <Commandefastfood, CommandefastfoodPK> {
}
