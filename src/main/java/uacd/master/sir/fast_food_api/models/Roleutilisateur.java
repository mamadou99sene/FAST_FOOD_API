package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
//@IdClass(RoleutilisateurPK.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Roleutilisateur {

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    @Column(name = "idutilisateur", nullable = false)
//    private int idutilisateur;
//
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    @Column(name = "idrole", nullable = false)
//    private int idrole;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", nullable = false)
    private Utilisateur utilisateurByIdutilisateur;

    @ManyToOne
    @JoinColumn(name = "idrole", referencedColumnName = "idrole", nullable = false)
    private Role roleByIdrole;


    /*

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
        Roleutilisateur that = (Roleutilisateur) o;
        return idutilisateur == that.idutilisateur && idrole == that.idrole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idutilisateur, idrole);
    }

    public Utilisateur getUtilisateurByIdutilisateur() {
        return utilisateurByIdutilisateur;
    }

    public void setUtilisateurByIdutilisateur(Utilisateur utilisateurByIdutilisateur) {
        this.utilisateurByIdutilisateur = utilisateurByIdutilisateur;
    }

    public Role getRoleByIdrole() {
        return roleByIdrole;
    }

    public void setRoleByIdrole(Role roleByIdrole) {
        this.roleByIdrole = roleByIdrole;
    }

     */
}
