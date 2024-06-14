package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Commande {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcommande", nullable = false)
    private int idcommande;
    @Basic
    @Column(name = "idutilisateur", nullable = false)
    private int idutilisateur;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;
    @Basic
    @Column(name = "status", nullable = true, length = 254)
    private String status;
    @ManyToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", nullable = false)
    private Utilisateur utilisateurByIdutilisateur;

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return idcommande == commande.idcommande && idutilisateur == commande.idutilisateur && Objects.equals(date, commande.date) && Objects.equals(status, commande.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcommande, idutilisateur, date, status);
    }

    public Utilisateur getUtilisateurByIdutilisateur() {
        return utilisateurByIdutilisateur;
    }

    public void setUtilisateurByIdutilisateur(Utilisateur utilisateurByIdutilisateur) {
        this.utilisateurByIdutilisateur = utilisateurByIdutilisateur;
    }
}
