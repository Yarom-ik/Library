package by.yarom.library.Entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "give")
public class Give {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_give")
    private int idGive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_book_id")
    private CatalogBooks catalogBooks;

    @Column(name = "data_return")
    private Date dataReturn;

    @Column(name = "finished")
    private boolean finished;

    public Give() {
    }

    public int getIdGive() {
        return idGive;
    }

    public void setIdGive(int idGive) {
        this.idGive = idGive;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CatalogBooks getCatalogBooks() {
        return catalogBooks;
    }

    public void setCatalogBooks(CatalogBooks catalogBooks) {
        this.catalogBooks = catalogBooks;
    }

    public Date getDataReturn() {
        return dataReturn;
    }

    public void setDataReturn(Date dataReturn) {
        this.dataReturn = dataReturn;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Give{" +
                "idGive=" + idGive +
                //", order=" + order +
                //", catalogBooks=" + catalogBooks +
                ", dataReturn='" + dataReturn + '\'' +
                ", finished=" + finished +
                '}';
    }
}
