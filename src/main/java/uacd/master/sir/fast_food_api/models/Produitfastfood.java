package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(ProduitfastfoodPK.class)
public class Produitfastfood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproduit", nullable = false)
    private int idproduit;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfastfood", nullable = false)
    private int idfastfood;
    @ManyToOne
    @JoinColumn(name = "idproduit", referencedColumnName = "idproduit", nullable = false)
    private Produit produitByIdproduit;
    @ManyToOne
    @JoinColumn(name = "idfastfood", referencedColumnName = "idfastfood", nullable = false)
    private Fastfood fastfoodByIdfastfood;

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
        Produitfastfood that = (Produitfastfood) o;
        return idproduit == that.idproduit && idfastfood == that.idfastfood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduit, idfastfood);
    }

    public Produit getProduitByIdproduit() {
        return produitByIdproduit;
    }

    public void setProduitByIdproduit(Produit produitByIdproduit) {
        this.produitByIdproduit = produitByIdproduit;
    }

    public Fastfood getFastfoodByIdfastfood() {
        return fastfoodByIdfastfood;
    }

    public void setFastfoodByIdfastfood(Fastfood fastfoodByIdfastfood) {
        this.fastfoodByIdfastfood = fastfoodByIdfastfood;
    }
}
