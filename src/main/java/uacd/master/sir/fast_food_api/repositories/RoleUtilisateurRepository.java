package uacd.master.sir.fast_food_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uacd.master.sir.fast_food_api.models.Roleutilisateur;
import uacd.master.sir.fast_food_api.models.Utilisateur;

public interface RoleUtilisateurRepository extends JpaRepository<Roleutilisateur, Integer> {

    Roleutilisateur findRoleutilisateurById(int id);
    Roleutilisateur findRoleutilisateurByUtilisateurByIdutilisateur(Utilisateur utilisateur);
    void deleteRoleutilisateurByUtilisateurByIdutilisateur(Utilisateur utilisateur);
}
