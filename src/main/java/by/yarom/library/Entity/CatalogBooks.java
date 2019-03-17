package by.yarom.library.Entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "catalog_books")
public class CatalogBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalog_book")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogBooks")
    Set<Give> gives;

    @Size(min = 1, max = 100, message = "Слишком длинное название книги")
    @NotBlank(message = "Название книги не может быть пустым")
    @Column (name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @Digits(integer=4, fraction=0, message = "Не более 4-х знаков")
    @Column (name = "year")
    private int year;

    @Digits(integer=6, fraction=0, message = "Не более 6-ти знаков")
    @Column (name = "inv_num")
    private int invNum;

    @Min(value = 0, message = "Неправильное количество книг")
    @Max(value = 9000, message = "Слишком большое количесво книг")
    @Column (name = "count_book")
    private int countBook;

    @Column (name = "active")
    private boolean active;

    public CatalogBooks(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Give> getGives() {
        return gives;
    }

    public void setGives(Set<Give> gives) {
        this.gives = gives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public int getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CatalogBooks{" +
                "id=" + id +
                ", category=" + category +
                ", gives=" + gives +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", year=" + year +
                ", invNum=" + invNum +
                ", countBook=" + countBook +
                ", active=" + active +
                '}';
    }
}
