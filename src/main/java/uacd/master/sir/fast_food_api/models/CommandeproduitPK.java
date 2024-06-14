package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class CommandeproduitPK implements Serializable {
    @Column(name = "idcommande", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcommande;
    @Column(name = "idproduit", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproduit;

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeproduitPK that = (CommandeproduitPK) o;
        return idcommande == that.idcommande && idproduit == that.idproduit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcommande, idproduit);
    }
}
