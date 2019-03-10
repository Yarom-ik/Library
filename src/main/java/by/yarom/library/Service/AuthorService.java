package by.yarom.library.Service;

import by.yarom.library.Entity.Author;

import java.util.List;

public interface AuthorService {

    void addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(int id);

    Author getAuthorByName(String name);

    List<Author> listAuthors();
}
