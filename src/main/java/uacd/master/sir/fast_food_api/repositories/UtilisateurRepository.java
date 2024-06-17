package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uacd.master.sir.fast_food_api.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findUtilisateurByIdutilisateur(int id);
    Utilisateur findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
