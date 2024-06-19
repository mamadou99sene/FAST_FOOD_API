package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class RoleutilisateurPK implements Serializable {
    @Column(name = "idutilisateur", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idutilisateur;

    @Column(name = "idrole", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrole;

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleutilisateurPK that = (RoleutilisateurPK) o;
        return idutilisateur == that.idutilisateur && idrole == that.idrole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idutilisateur, idrole);
    }
}
