package by.yarom.library.DAO.impl;

import by.yarom.library.DAO.AuthorDao;
import by.yarom.library.Entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("author")
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAuthor(Author author) {
        currentSession().save(author);

    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteAuthor(int id) {

    }

    @Override
    public Author getAuthorByName(String name) {
        Author author = (Author) currentSession().createQuery("from Author a where a.authorName =:nam")
                .setParameter("nam", name)
                .uniqueResult();
        return author;
    }

    @Override
    public List<Author> listAuthors() {
        List<Author> authorList = currentSession().createQuery("from Author ").list();
        return authorList;
    }
}
