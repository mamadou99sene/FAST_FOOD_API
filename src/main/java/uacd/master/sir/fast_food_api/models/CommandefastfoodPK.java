package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class CommandefastfoodPK implements Serializable {
    @Column(name = "idcommande", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcommande;
    @Column(name = "idfastfood", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idfastfood;

    public CommandefastfoodPK() {}

    public CommandefastfoodPK(int idcommande, int idfastfood) {
        this.idcommande = idcommande;
        this.idfastfood = idfastfood;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
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
        CommandefastfoodPK that = (CommandefastfoodPK) o;
        return idcommande == that.idcommande && idfastfood == that.idfastfood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcommande, idfastfood);
    }
}
