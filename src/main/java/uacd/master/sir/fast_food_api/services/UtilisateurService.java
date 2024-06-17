package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.dto.UtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.dto.UtilisateurResponseDTO;
import uacd.master.sir.fast_food_api.models.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    public UtilisateurResponseDTO create(UtilisateurRequestDTO requestDTO);
    public String delete(int id);
    public UtilisateurResponseDTO update(int id, UtilisateurRequestDTO requestDTO);
    public List<UtilisateurResponseDTO> readAll();
    public UtilisateurResponseDTO readById(int id);
}
