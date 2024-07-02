package uacd.master.sir.fast_food_api.services;

import uacd.master.sir.fast_food_api.models.Categorie;

import java.util.List;

public interface CategorieService {

    List <Categorie>getAllCategorie();
   Categorie getCategorieById(int idCategorie);
   Categorie saveCategorie(Categorie categorie);
  Boolean deleteCategorie(int idCategorie);
  Categorie updateCategorie(Categorie categorie, int idCategorie);

}
