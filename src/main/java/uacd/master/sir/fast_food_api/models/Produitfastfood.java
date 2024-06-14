package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.IdClass(uacd.master.sir.fast_food_api.models.ProduitfastfoodPK.class)
public class Produitfastfood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "idproduit", nullable = false)
    private int idproduit;

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "idfastfood", nullable = false)
    private int idfastfood;

    public int getIdfastfood() {
        return idfastfood;
    }

    public void setIdfastfood(int idfastfood) {
        this.idfastfood = idfastfood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produitfastfood that = (Produitfastfood) o;
        return idproduit == that.idproduit && idfastfood == that.idfastfood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduit, idfastfood);
    }
}
