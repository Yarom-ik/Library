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
        List<Reader> readerList = currentSession().createQuery("from Reader r where r.active = true ")
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return readerList;
    }

    @Override
    public Long countFindReader() {
        return (Long) currentSession().createQuery("select count (*) from Reader r where r.active = true ").uniqueResult();
    }

    @Override
    public List<Reader> listReaderByChar(String actionChar, Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;
        Query query =  currentSession().createQuery("from Reader c where c.firstName like :s and c.active = true ");
        List<Reader> listReaderByChar = query
                .setParameter("s",actionChar +"%")
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        return listReaderByChar;
    }

    @Override
    public Long countFindReaderByChar(String actionChar) {
        Query query = currentSession().createQuery("select count (*) from Reader c where c.firstName like :s and c.active = true");
        return (Long) query.setParameter("s",actionChar +"%").uniqueResult();
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
                query = currentSession().createQuery("from Reader c where c.firstName like :name and c.active = true");
                query.setParameter("name",list.get(0) + "%");
                break;
            }
            case 2: {
                query = currentSession().createQuery("from Reader c where c.firstName like :name and c.lastName like:lastName and c.active = true ");
                query.setParameter("name",list.get(0)+ "%")
                        .setParameter("lastName", list.get(1)+ "%");
                break;
            }
            case 3: {
                query = currentSession().createQuery("from Reader c where c.firstName like :name and c.lastName like:lastName and c.middleName like:middleName and c.active = true ");
                query.setParameter("name",list.get(0)+ "%")
                        .setParameter("lastName", list.get(1)+ "%")
                        .setParameter("middleName", list.get(2)+ "%");
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
                query = currentSession().createQuery("select count (*) from Reader c where c.firstName like :name and c.active = true");
                query.setParameter("name",list.get(0) +"%");
                break;
            }
            case 2: {
                query = currentSession().createQuery("select count (*) from Reader c where c.firstName like :name and c.lastName like:lastName and c.active = true");
                query.setParameter("name",list.get(0)+"%")
                        .setParameter("lastName", list.get(1)+"%");
                break;
            }
            case 3: {
                query = currentSession().createQuery("select count (*) from Reader c where c.firstName like :name and c.lastName like:lastName and c.middleName like:middleName and c.active = true");
                query.setParameter("name",list.get(0)+"%")
                        .setParameter("lastName", list.get(1)+"%")
                        .setParameter("middleName", list.get(2)+"%");
                break;
            }
        }

        return (Long) query.uniqueResult();
    }

    @Override
    public Reader getReaderById(int id) {
            Reader reader = (Reader) currentSession().createQuery("from Reader r where r.id =:id and r.active = true ")
                    .setParameter("id", id)
                    .uniqueResult();
        return reader;
    }

    @Override
    public Reader getReaderByFirsName(String firsName) {

        Reader reader = (Reader) currentSession().createQuery("from Reader r where r.firstName =:firstName and r.active = true ")
                .setParameter("firstName", firsName)
                .setMaxResults(1)
                .uniqueResult();
        return reader;
    }

    @Override
    public Reader getReaderByLastName(String lastName) {
        Reader reader = (Reader) currentSession().createQuery("from Reader r where r.lastName =:lastName and r.active = true ")
                .setParameter("lastName", lastName)
                .setMaxResults(1)
                .uniqueResult();
        return reader;
    }

    @Override
    public Reader getReaderByMiddleName(String middleName) {
        Reader reader = (Reader) currentSession().createQuery("from Reader r where r.middleName =:middleName and r.active = true ")
                .setParameter("middleName", middleName)
                .setMaxResults(1)
                .uniqueResult();
        return reader;
    }

    @Override
    public List<Reader> listReaderByOwes(Integer page) {
        Integer maxResult = 10;
        page = (page - 1) * 10;
        List<Reader> readerList = currentSession().createQuery("select r from Reader r join fetch r.orders as rr where rr.finished = false and r.active = true group by r")
                .setFirstResult(page!=null?page:0)
                .setMaxResults(maxResult!=null?maxResult:10)
                .list();
        System.out.println(readerList);
        return readerList;
    }

    @Override
    public Long countFindReaderByOwes() {
        List list = currentSession().createQuery("select r from Reader r join fetch r.orders as rr where rr.finished = false and r.active = true group by r").list();
        return Long.valueOf(list.size());
    }

    @Override
    public Reader getReaderByFIO(String firsName, String lastName, String middleName) {
        Reader reader = (Reader) currentSession().createQuery("from Reader r where r.firstName =:firstName and r.lastName =:lastName and r.middleName =:middleName")
                .setParameter("firstName", firsName)
                .setParameter("lastName", lastName)
                .setParameter("middleName", middleName)
                .setMaxResults(1)
                .uniqueResult();


        return reader;
    }
}
