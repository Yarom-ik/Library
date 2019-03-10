package by.yarom.library.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categoryes")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_category")
    private int id_Category;

    @Column (name = "name")
    private String categoryName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<CatalogBooks> catalogBooks;

    public Category() {
    }

    public int getId_Category() {
        return id_Category;
    }

    public void setId_Category(int id_Category) {
        this.id_Category = id_Category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<CatalogBooks> getCatalogBooks() {
        return catalogBooks;
    }

    public void setCatalogBooks(Set<CatalogBooks> catalogBooks) {
        this.catalogBooks = catalogBooks;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id_Category=" + id_Category +
                ", categoryName='" + categoryName + '\'' +
                //", catalogBooks=" + catalogBooks +
                '}';
    }
}
