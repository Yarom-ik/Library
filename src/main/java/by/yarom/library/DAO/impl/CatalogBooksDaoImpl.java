package by.yarom.library.DAO.impl;

import by.yarom.library.DAO.CatalogBooksDao;
import by.yarom.library.Entity.CatalogBooks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CatalogBooksDao")
public class CatalogBooksDaoImpl implements CatalogBooksDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBook(CatalogBooks catalogBooks) {
        currentSession().save(catalogBooks);
    }

    @Override
    public void updateBook(CatalogBooks catalogBooks) {
        currentSession().update(catalogBooks);

    }


    @Override

    public void deleteBook(int id) {
        currentSession().delete(getCatalogBooksById(id));

    }

    @Override
    public CatalogBooks getCatalogBooksById(int id) {
        return (CatalogBooks) currentSession().get(CatalogBooks.class, id);
    }

    @Override
    public List<CatalogBooks> listCatalogBooks(Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;
        List<CatalogBooks> catalogBooksList =  currentSession().createQuery("from CatalogBooks ")
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return  catalogBooksList;
    }

    @Override
    public Long countFindBook() {
        return (Long) currentSession().createCriteria(CatalogBooks.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<CatalogBooks> listBooksByChar(String s, Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;
        Query query =  currentSession().createQuery("from CatalogBooks c where c.name like :s");
        List<CatalogBooks> booksByName = query
                .setParameter("s",s +"%")
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return booksByName;
    }

    @Override
    public Long countFindBookByChar(String s) {
        Query query = currentSession().createQuery("from CatalogBooks c where c.name like :s");
        List<CatalogBooks> booksByName = query.setParameter("s",s +"%").list();
        return Long.valueOf(booksByName.size());
    }

    @Override
    public List<CatalogBooks> listBooksByParam(String name, String param,Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;

        Query query = null;
        switch (param){
            case "name": {
                query = currentSession().createQuery("from CatalogBooks c where c.name = :name");
                break;
            }
            case "author":{
                query =  currentSession().createQuery("from CatalogBooks c where c.author.authorName = :name");
                break;
            }
            case "category":{
                query =  currentSession().createQuery("from CatalogBooks c where c.category.categoryName = :name");
                break;
            }
            case "invNum":{
                query =  currentSession().createQuery("from CatalogBooks c where c.invNum = :name");
                List<CatalogBooks> booksByParam = query.setParameter("name", new Integer(name))
                        .setFirstResult(page!=null?page:0)
                        .setMaxResults(maxResult!=null?maxResult:10)
                        .list();
                return booksByParam;

            }
        }
        List<CatalogBooks> booksByParam = query.setParameter("name", name)
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return booksByParam;
    }

    @Override
    public Long countFindBookByParam(String name, String param) {
        Query query = null;
        switch (param){
            case "name": {
                query = currentSession().createQuery("from CatalogBooks c where c.name = :name");
                break;
            }
            case "author":{
                query =  currentSession().createQuery("from CatalogBooks c where c.author.authorName = :name");
                break;
            }
            case "category":{
                query =  currentSession().createQuery("from CatalogBooks c where c.category.categoryName = :name");
                break;
            }
            case "invNum":{
                query =  currentSession().createQuery("from CatalogBooks c where c.invNum = :name");
                List<CatalogBooks> booksByParam = query.setParameter("name", new Integer(name)).list();
                return Long.valueOf(booksByParam.size());
            }
        }
        List<CatalogBooks> booksByParam = query.setParameter("name", name).list();
        return Long.valueOf(booksByParam.size());
    }

    @Override
    public CatalogBooks getCatalogBookByInvNum(int invNum) {
        CatalogBooks catalogBooks = (CatalogBooks) currentSession().createQuery("from CatalogBooks c where c.invNum =:inv")
                .setParameter("inv",invNum)
                .setMaxResults(1)
                .uniqueResult();
        return catalogBooks;
    }
}


