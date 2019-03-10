package by.yarom.library.DAO;

import by.yarom.library.Entity.Order;

import java.util.List;

public interface OrderDao {

    void addOrder(Order order);

    void deleteOrder(Order order);

    void updateOrder(Order order);

    List<Order> orderList();

    Order getOrderById(int idOrder);

    List<Order> orderListByReaderId(int id);
}
