package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.models.Categorie;
import uacd.master.sir.fast_food_api.models.Categorie;
import uacd.master.sir.fast_food_api.repositories.CategorieRepository;
import uacd.master.sir.fast_food_api.services.CategorieService;

import java.util.List;
@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    private CategorieRepository categorieRepository;
    @Override
    public List<Categorie> getAllCategorie() {
        return this.categorieRepository.findAll().stream().toList();
    }

    @Override
    public Categorie getCategorieById(int idCategorie) {
        return this.categorieRepository.findById(idCategorie).get();
    }

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return this.categorieRepository.save(categorie);
    }

    @Override
    public Boolean deleteCategorie(int idCategorie) {
       Categorie categorie= this.categorieRepository.findById(idCategorie).get();
        this.categorieRepository.delete(categorie);
        return true;
    }

    @Override
    public Categorie updateCategorie(Categorie newCategorie, int idCategorie) {
        Categorie categorie=categorieRepository.findById(idCategorie).orElse(null);

        if(categorie != null)
        {
            categorie.setNom(newCategorie.getNom());
            categorie.setDescription(newCategorie.getDescription());
            return this.categorieRepository.save(categorie);
        }
        return null;
    }
}