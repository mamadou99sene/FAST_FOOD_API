package uacd.master.sir.fast_food_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.IdClass(uacd.master.sir.fast_food_api.model.CommandefastfoodPK.class)
public class Commandefastfood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "idcommande")
    private int idcommande;

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "idfastfood")
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
        Commandefastfood that = (Commandefastfood) o;
        return idcommande == that.idcommande && idfastfood == that.idfastfood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcommande, idfastfood);
    }
}
