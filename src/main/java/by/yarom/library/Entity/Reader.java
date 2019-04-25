package by.yarom.library.Entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table (name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reader")
    private int idReader;

    @Size(min = 1, max = 45, message = "Слишком длинная фамилия")
    @NotBlank(message = "Поле фамилия не может быть пустым")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 1, max = 45, message = "Слишком длинное имя")
    @NotBlank(message = "Поле имя не может быть пустым")
    @Column(name = "last_name")
    private String lastName;

    @Size(min = 1, max = 45, message = "Слишком длинное отчество")
    @NotBlank(message = "Поле отчество не может быть пустым")
    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "telephone")
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private Users users;

    @Column(name = "active")
    private boolean active;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "reader")
    private Set<Order> orders;

    public Reader() {
    }

    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "idReader=" + idReader +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", active=" + active +
                ", orders=" + orders +
                '}';
    }
}
