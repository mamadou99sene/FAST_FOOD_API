package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.UtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.dto.UtilisateurResponseDTO;
import uacd.master.sir.fast_food_api.models.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    UtilisateurResponseDTO create(UtilisateurRequestDTO requestDTO);
    String delete(int id);
    UtilisateurResponseDTO update(int id, UtilisateurRequestDTO requestDTO);
    List<UtilisateurResponseDTO> readAll();
    UtilisateurResponseDTO readById(int id);
    Boolean verifyToken(String token);


}
