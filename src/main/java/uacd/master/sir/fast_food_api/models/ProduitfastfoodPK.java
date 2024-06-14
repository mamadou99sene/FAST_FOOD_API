package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class ProduitfastfoodPK implements Serializable {
    @Column(name = "idproduit", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproduit;
    @Column(name = "idfastfood", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfastfood;

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

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
        ProduitfastfoodPK that = (ProduitfastfoodPK) o;
        return idproduit == that.idproduit && idfastfood == that.idfastfood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduit, idfastfood);
    }
}
