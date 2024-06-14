package uacd.master.sir.fast_food_api.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "idcategorie")
    private int idcategorie;

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    @Basic
    @Column(name = "nom")
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return idcategorie == categorie.idcategorie && Objects.equals(nom, categorie.nom) && Objects.equals(description, categorie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcategorie, nom, description);
    }
}
