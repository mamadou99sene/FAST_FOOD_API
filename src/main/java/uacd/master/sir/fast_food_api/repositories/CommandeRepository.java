package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uacd.master.sir.fast_food_api.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
