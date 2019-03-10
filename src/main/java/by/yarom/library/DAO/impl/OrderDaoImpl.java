package by.yarom.library.DAO.impl;

import by.yarom.library.DAO.OrderDao;
import by.yarom.library.Entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addOrder(Order order) {
        currentSession().save(order);
    }

    @Override
    public void deleteOrder(Order order) {
        currentSession().delete(order);

    }

    @Override
    public void updateOrder(Order order) {
        currentSession().update(order);
    }

    @Override
    public List<Order> orderList() {
        List<Order> orderList =  currentSession().createQuery("from Order ").list();
        return orderList;
    }

    @Override
    public Order getOrderById(int idOrder) {
        return currentSession().get(Order.class,idOrder);
    }

    @Override
    public List<Order> orderListByReaderId(int id) {
        List<Order> orderListByReaderId =  currentSession().createQuery("from Order where reader.id = :id order by idOrder desc ")
                .setParameter("id", id)
                .list();
        return orderListByReaderId;
    }
}
