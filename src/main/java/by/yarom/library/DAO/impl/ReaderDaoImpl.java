package by.yarom.library.DAO.impl;

import by.yarom.library.DAO.ReaderDao;
import by.yarom.library.Entity.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

@Repository("ReaderDao")
public class ReaderDaoImpl implements ReaderDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addReader(Reader reader) {
        currentSession().save(reader);
    }

    @Override
    public void deleteReader(Reader reader) {
        currentSession().delete(reader);
    }

    @Override
    public void updateReader(Reader reader) {
        currentSession().update(reader);
    }

    @Override
    public List<Reader> listReader(Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;
        List<Reader> readerList = currentSession().createQuery("from Reader ")
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return readerList;
    }

    @Override
    public Long countFindReader() {
        return (Long) currentSession().createCriteria(Reader.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<Reader> listReaderByChar(String actionChar, Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;
        Query query =  currentSession().createQuery("from Reader c where c.firstName like :s");
        List<Reader> listReaderByChar = query
                .setParameter("s",actionChar +"%")
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return listReaderByChar;
    }

    @Override
    public Long countFindReaderByChar(String actionChar) {
        Query query = currentSession().createQuery("from Reader c where c.firstName like :s");
        List<Reader> countFindReaderByChar = query.setParameter("s",actionChar +"%").list();
        return Long.valueOf(countFindReaderByChar.size());
    }

    @Override
    public List<Reader> listReaderByName(String name, Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;
        List<String> list = new LinkedList<>();
        for (String fio : name.split(" ")) {
            System.out.println(fio);
            list.add(fio);
        }
        Query query = null;
        switch (list.size()){
            case 1: {
                query = currentSession().createQuery("from Reader c where c.firstName = :name");
                query.setParameter("name",list.get(0));
                break;
            }
            case 2: {
                query = currentSession().createQuery("from Reader c where c.firstName = :name and c.lastName =:lastName");
                query.setParameter("name",list.get(0))
                        .setParameter("lastName", list.get(1));
                break;
            }
            case 3: {
                query = currentSession().createQuery("from Reader c where c.firstName = :name and c.lastName =:lastName and c.middleName =:middleName");
                query.setParameter("name",list.get(0))
                        .setParameter("lastName", list.get(1))
                        .setParameter("middleName", list.get(2));
                break;
            }
            default:
                return null;
        }

        List<Reader> listReaderByName = query
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return listReaderByName;
    }

    @Override
    public Long countFindReaderByName(String name) {
        List<String> list = new LinkedList<>();
        for (String fio : name.split(" ")) {
            list.add(fio);
        }
        Query query = null;
        switch (list.size()){
            case 1: {
                query = currentSession().createQuery("from Reader c where c.firstName = :name");
                query.setParameter("name",list.get(0));
                break;
            }
            case 2: {
                query = currentSession().createQuery("from Reader c where c.firstName = :name and c.lastName =:lastName");
                query.setParameter("name",list.get(0))
                        .setParameter("lastName", list.get(1));
                break;
            }
            case 3: {
                query = currentSession().createQuery("from Reader c where c.firstName = :name and c.lastName =:lastName and c.middleName =:middleName");
                query.setParameter("name",list.get(0))
                        .setParameter("lastName", list.get(1))
                        .setParameter("middleName", list.get(2));
                break;
            }
        }


        List<Reader> countFindReaderByName = query.list();
        return Long.valueOf(countFindReaderByName.size());
    }

    @Override
    public Reader getReaderById(int id) {

        return (Reader) currentSession().get(Reader.class, id);
    }

    @Override
    public Reader getReaderByFirsName(String firsName) {

        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Reader> criteria = builder.createQuery(Reader.class);
        Root<Reader> readerRoot = criteria.from(Reader.class);
        criteria.select(readerRoot);
        criteria.where(builder.equal(readerRoot.get("firsName"), firsName));
        Reader reader = currentSession().createQuery(criteria).uniqueResult();

        return reader;
    }
}
