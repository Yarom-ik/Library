package by.yarom.library.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @OneToOne(mappedBy = "users", fetch = FetchType.EAGER)
    private Reader reader;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @Size(min = 1, max = 45, message = "Слишком длинный логин (max45 символов)")
    @Column(name = "login")
    private String login;

    @Size(min = 1, max = 45, message = "Слишком длинный пароль (max45 символов)")
    @Column(name = "password")
    private String password;

    @Size(min = 1, max = 45, message = "Слишком длинный email (max45 символов)")
    @Column(name = "email")
    private String email;

    public boolean isAdmin(){
        return role.getName().contains("admin");
    }

    public boolean isReader(){
        return role.getName().contains("reader");
    }

    public boolean isLibrary(){
        return role.getName().contains("library");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reader getReader() {
        return reader;
    }


    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + idUser +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
