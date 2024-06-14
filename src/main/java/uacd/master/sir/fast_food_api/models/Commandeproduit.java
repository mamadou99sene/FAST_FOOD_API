package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(CommandeproduitPK.class)
public class Commandeproduit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcommande", nullable = false)
    private int idcommande;

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproduit", nullable = false)
    private int idproduit;

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
        Commandeproduit that = (Commandeproduit) o;
        return idcommande == that.idcommande && idproduit == that.idproduit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcommande, idproduit);
    }
}
