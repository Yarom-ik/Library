package by.yarom.library.DAO;

import by.yarom.library.Entity.Author;

import java.util.List;

public interface AuthorDao {

    void addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(int id);

    Author getAuthorByName(String name);

    List<Author> listAuthors();
}
