package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@IdClass(CommandefastfoodPK.class)
public class Commandefastfood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcommande", nullable = false)
    private int idcommande;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idfastfood", nullable = false)
    private int idfastfood;
    @ManyToOne
    @JoinColumn(name = "idfastfood", referencedColumnName = "idfastfood", insertable = false, updatable = false)
    private Fastfood fastfoodByIdfastfood;

// Ajoutez également les getters et setters pour cette propriété

    public Fastfood getFastfoodByIdfastfood() {
        return fastfoodByIdfastfood;
    }

    public void setFastfoodByIdfastfood(Fastfood fastfoodByIdfastfood) {
        this.fastfoodByIdfastfood = fastfoodByIdfastfood;
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
        Commandefastfood that = (Commandefastfood) o;
        return idcommande == that.idcommande && idfastfood == that.idfastfood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcommande, idfastfood);
    }
}
