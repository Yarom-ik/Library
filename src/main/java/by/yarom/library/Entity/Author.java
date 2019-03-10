package by.yarom.library.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private int idAuthor;

    @Size(min = 1, max = 100, message = "Слишком длинное название автора")
    @NotBlank(message = "Название автора не может быть пустым")
    @Column (name = "author_name")
    private String authorName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private Set<CatalogBooks> catalogBooks;

    public Author(){
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<CatalogBooks> getCatalogBooks() {
        return catalogBooks;
    }

    public void setCatalogBooks(Set<CatalogBooks> catalogBooks) {
        this.catalogBooks = catalogBooks;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", authorName='" + authorName + '\'' +
//                ", catalogBooks=" + catalogBooks +
                '}';
    }
}
