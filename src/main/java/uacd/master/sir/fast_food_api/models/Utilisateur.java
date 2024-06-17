package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Utilisateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idutilisateur", nullable = false)
    private int idutilisateur;
    @Basic
    @Column(name = "prenom", nullable = true, length = 254)
    private String prenom;
    @Basic
    @Column(name = "nom", nullable = true, length = 254)
    private String nom;
    @Basic
    @Column(name = "email", nullable = true, length = 254)
    private String email;
    @Basic
    @Column(name = "password", nullable = true, length = 254)
    private String password;
    @Basic
    @Column(nullable = true)
    private boolean isEnabled;

    @OneToMany(mappedBy = "utilisateurByIdutilisateur")
    private List<Commande> commandesByIdutilisateur;
    @OneToMany(mappedBy = "utilisateurByIdutilisateur")
    private List<Fastfood> fastfoodsByIdutilisateur;
    @OneToMany(mappedBy = "utilisateurByIdutilisateur")
    private List<Roleutilisateur> roleutilisateursByIdutilisateur;

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return idutilisateur == that.idutilisateur && Objects.equals(prenom, that.prenom) && Objects.equals(nom, that.nom) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idutilisateur, prenom, nom, email, password);
    }

    public List<Commande> getCommandesByIdutilisateur() {
        return commandesByIdutilisateur;
    }

    public void setCommandesByIdutilisateur(List<Commande> commandesByIdutilisateur) {
        this.commandesByIdutilisateur = commandesByIdutilisateur;
    }

    public List<Fastfood> getFastfoodsByIdutilisateur() {
        return fastfoodsByIdutilisateur;
    }

    public void setFastfoodsByIdutilisateur(List<Fastfood> fastfoodsByIdutilisateur) {
        this.fastfoodsByIdutilisateur = fastfoodsByIdutilisateur;
    }

    public List<Roleutilisateur> getRoleutilisateursByIdutilisateur() {
        return roleutilisateursByIdutilisateur;
    }

    public void setRoleutilisateursByIdutilisateur(List<Roleutilisateur> roleutilisateursByIdutilisateur) {
        this.roleutilisateursByIdutilisateur = roleutilisateursByIdutilisateur;
    }
}
