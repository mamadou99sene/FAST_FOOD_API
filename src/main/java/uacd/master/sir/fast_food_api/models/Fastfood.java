package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Fastfood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfastfood", nullable = false)
    private int idfastfood;
    @Basic
    @Column(name = "idutilisateur", nullable = false)
    private int idutilisateur;
    @Basic
    @Column(name = "nom", nullable = true, length = 254)
    private String nom;
    @Basic
    @Column(name = "description", nullable = true, length = 254)
    private String description;
    @Basic
    @Column(name = "localisation", nullable = true, length = 254)
    private String localisation;
    @ManyToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", nullable = false, insertable = false, updatable = false)
    private Utilisateur utilisateurByIdutilisateur;
    @OneToMany(mappedBy = "fastfoodByIdfastfood")
    private List<Commandefastfood> commandefastfoodsByIdfastfood;
    @OneToMany(mappedBy = "fastfoodByIdfastfood")
    private List<Produitfastfood> produitfastfoodsByIdfastfood;

    public int getIdfastfood() {
        return idfastfood;
    }

    public void setIdfastfood(int idfastfood) {
        this.idfastfood = idfastfood;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fastfood fastfood = (Fastfood) o;
        return idfastfood == fastfood.idfastfood && idutilisateur == fastfood.idutilisateur && Objects.equals(nom, fastfood.nom) && Objects.equals(description, fastfood.description) && Objects.equals(localisation, fastfood.localisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfastfood, idutilisateur, nom, description, localisation);
    }

    public Utilisateur getUtilisateurByIdutilisateur() {
        return utilisateurByIdutilisateur;
    }

    public void setUtilisateurByIdutilisateur(Utilisateur utilisateurByIdutilisateur) {
        this.utilisateurByIdutilisateur = utilisateurByIdutilisateur;
    }

    public List<Commandefastfood> getCommandefastfoodsByIdfastfood() {
        return commandefastfoodsByIdfastfood;
    }

    public void setCommandefastfoodsByIdfastfood(List<Commandefastfood> commandefastfoodsByIdfastfood) {
        this.commandefastfoodsByIdfastfood = commandefastfoodsByIdfastfood;
    }

    public List<Produitfastfood> getProduitfastfoodsByIdfastfood() {
        return produitfastfoodsByIdfastfood;
    }

    public void setProduitfastfoodsByIdfastfood(List<Produitfastfood> produitfastfoodsByIdfastfood) {
        this.produitfastfoodsByIdfastfood = produitfastfoodsByIdfastfood;
    }
}
