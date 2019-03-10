package by.yarom.library.Entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="reader_id")
    private Reader reader;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Give> gives;

    @Column(name = "data_order")
    private Date data;

    @Column(name = "finished")
    private boolean finished;

    public Order() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Set<Give> getGives() {
        return gives;
    }

    public void setGives(Set<Give> gives) {
        this.gives = gives;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                //", reader=" + reader +
                ", gives=" + gives +
                ", data='" + data + '\'' +
                ", finished=" + finished +
                '}';
    }
}
