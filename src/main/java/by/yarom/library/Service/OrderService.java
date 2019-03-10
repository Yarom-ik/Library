package by.yarom.library.Service;

import by.yarom.library.Entity.Order;
import org.springframework.ui.Model;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    void deleteOrder(Order order);

    List<Order> orderList();

    Order getOrderById(int id);

    List<Order> orderListByReaderId(int id);

}
