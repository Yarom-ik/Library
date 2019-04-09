package by.yarom.library.DAO.impl;

import by.yarom.library.DAO.GiveDao;
import by.yarom.library.Entity.Give;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository("GiveDao")
public class GiveDaoImpl implements GiveDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addGive(Give give) {
        currentSession().save(give);
    }

    @Override
    public void deleteGive(Give give) {
        currentSession().delete(give);

    }

    @Override
    public void updateGive(Give give) {
        currentSession().update(give);
    }

    @Override
    public Give getGiveById(int id) {
       return (Give) currentSession().get(Give.class, id);
    }

    @Override
    public List<Give> giveList() {
        List<Give> giveList = currentSession().createQuery("from Give").list();
        return giveList;
    }

    @Override
    public List<Give> giveListByFinished(boolean finish) {
        return null;
    }

    @Override
    public List<Give> giveListByOrderId(int idOrder, int idReader) {
        List<Give> giveListByOrderId = currentSession().createQuery("from Give where order.idOrder = :idOrder and order.reader.idReader =:idReader")
                .setParameter("idOrder",idOrder)
                .setParameter("idReader",idReader)
                .list();
        return giveListByOrderId;
    }

    @Override
    public List<Give> giveListByOrderIdByFinished(int idOrder, int idReader, boolean finish) {
        List<Give> giveListByOrderIdByFinished = currentSession().createQuery("from Give where order.idOrder = :idOrder " +
                "and order.reader.idReader =:idReader and finished = :finish")
                .setParameter("idOrder",idOrder)
                .setParameter("idReader",idReader)
                .setParameter("finish", finish)
                .list();
        return giveListByOrderIdByFinished;
    }

    @Override
    public List<Give> giveListByReaderByBooksNotFinished(String firstName, String lastName, String middleName) {

        List<Give> giveListByReaderByBooksNotFinished = currentSession().createQuery("from Give where order.reader.firstName =:firstName " +
                "and order.reader.lastName =:lastName and order.reader.middleName =: middleName and finished = false ")
                        .setParameter("firstName",firstName)
                        .setParameter("lastName", lastName)
                        .setParameter("middleName", middleName)
                        .list();

        return giveListByReaderByBooksNotFinished;
    }

    @Override
    public long giveStatistic(Date startDate, Date endDate) {
        long count = (Long) currentSession().createQuery("select count (*) from Give where order.data between :startDate and :endDate")
                .setParameter("startDate",  startDate)
                .setParameter("endDate", endDate)
                .uniqueResult();
        return count;
    }
}
