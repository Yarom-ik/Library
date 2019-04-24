package by.yarom.library.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public boolean isAdmin(){
        return role.getName().contains("admin");
    }

    public boolean isReader(){
        return role.getName().contains("reader");
    }

    public Users() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + idUser +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
