package uacd.master.sir.fast_food_api.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrole", nullable = false)
    private int idrole;
    @Basic
    @Column(name = "role", nullable = true, length = 254)
    private String role;
    @Basic
    @Column(name = "description", nullable = true, length = 254)
    private String description;
    @OneToMany(mappedBy = "roleByIdrole")
    private List<Roleutilisateur> roleutilisateursByIdrole;

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
        Role role1 = (Role) o;
        return idrole == role1.idrole && Objects.equals(role, role1.role) && Objects.equals(description, role1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrole, role, description);
    }

    public List<Roleutilisateur> getRoleutilisateursByIdrole() {
        return roleutilisateursByIdrole;
    }

    public void setRoleutilisateursByIdrole(List<Roleutilisateur> roleutilisateursByIdrole) {
        this.roleutilisateursByIdrole = roleutilisateursByIdrole;
    }
}
