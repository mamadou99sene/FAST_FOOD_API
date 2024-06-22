package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproduit", nullable = false)
    private int idproduit;
    @Basic
    @Column(name = "idcategorie", nullable = false)
    private int idcategorie;
    @Basic
    @Column(name = "nom", nullable = true, length = 254)
    private String nom;
    @Basic
    @Column(name = "description", nullable = true, length = 254)
    private String description;
    @Basic
    @Column(name = "prix", nullable = true, precision = 0)
    private BigInteger prix;

//    @Basic
//    @Column(name = "image", nullable = true, length = 254)
//    private String image;

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    private List<ImageProduit> imageProduits;

    @OneToMany(mappedBy = "produitByIdproduit")
    private List<Produitfastfood> produitfastfoodsByIdproduit;

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getPrix() {
        return prix;
    }

    public void setPrix(BigInteger prix) {
        this.prix = prix;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Produit produit = (Produit) o;
//        return idproduit == produit.idproduit && idcategorie == produit.idcategorie && Objects.equals(nom, produit.nom) && Objects.equals(description, produit.description) && Objects.equals(prix, produit.prix) && Objects.equals(image, produit.image);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(idproduit, idcategorie, nom, description, prix, image);
//    }
//
//    public List<Produitfastfood> getProduitfastfoodsByIdproduit() {
//        return produitfastfoodsByIdproduit;
//    }
//
//    public void setProduitfastfoodsByIdproduit(List<Produitfastfood> produitfastfoodsByIdproduit) {
//        this.produitfastfoodsByIdproduit = produitfastfoodsByIdproduit;
//    }
}
