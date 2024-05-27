package controller;

import model.Order;
import model.Request;
import model.subsytem.OrderSystem;

import java.util.ArrayList;

public class OrderController {
    private final OrderSystem orderSystem = new OrderSystem();
    public ArrayList<Order> orders;
    public Order order;

    public OrderController() {

    }

    public void insert(Order order) {
        orderSystem.insert(order);
    }

    // Lấy tất cả orders
    public ArrayList<Order> getAllOrders() {
        orders = orderSystem.selectAll();
        return orders;
    }

    // Lấy order bằng id
    public Order getOrderById(int id) {
        order = orderSystem.selectById(id);
        return order;
    }

    // Lấy tất cả các orders đang chờ xử lý
    public ArrayList<Order> getAllWaitOrders() {
        orders = orderSystem.selectByStatus("Chờ xử lý");
        return orders;
    }

    // Lấy các orders trong request
    public ArrayList<Order> getOrdersInRequest(int request_id) {
        orders = orderSystem.selectByRequestId(request_id);
        return orders;
    }

    // Update status
    public void updateStatus(int id, String status) {
        orderSystem.updateStatus(id, status);
    }

    // Lấy tất cả order trong request có status là chờ xử lý
    public ArrayList<Order> getWaitOrdersInRequest(int request_id) {
        orders = orderSystem.selectByStatusInRequest(request_id, "Chờ xử lý");
        return orders;
    }
}
