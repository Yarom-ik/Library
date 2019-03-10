package by.yarom.library.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table (name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reader")
    private int idReader;

    @NotBlank(message = "Поле фамилия не может быть пустым")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Поле имя не может быть пустым")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Поле отчество не может быть пустым")
    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "telephone")
    private String telephone;

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

    public Set<Order> getOrder() {
        return orders;
    }

    public void setOrder(Set<Order> order) {
        this.orders = order;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "idReader=" + idReader +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", order=" + orders +
                '}';
    }
}
