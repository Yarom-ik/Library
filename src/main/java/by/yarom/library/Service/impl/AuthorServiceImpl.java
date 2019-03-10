package by.yarom.library.Service.impl;

import by.yarom.library.DAO.AuthorDao;
import by.yarom.library.Entity.Author;
import by.yarom.library.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public void addAuthor(Author author) {
        authorDao.addAuthor(author);

    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteAuthor(int id) {

    }

    @Override
    public Author getAuthorByName(String name) {
        return authorDao.getAuthorByName(name);
    }

    @Override
    public List<Author> listAuthors() {
        return this.authorDao.listAuthors();
    }
}
