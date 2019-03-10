package by.yarom.library.Service.impl;

import by.yarom.library.DAO.OrderDao;
import by.yarom.library.Entity.Order;
import by.yarom.library.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.deleteOrder(order);

    }

    @Override
    public List<Order> orderList() {
        return orderDao.orderList();
    }

    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> orderListByReaderId(int id) {
        return orderDao.orderListByReaderId(id);
    }


}
