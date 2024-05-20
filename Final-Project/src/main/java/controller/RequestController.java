package controller;

import model.Order;
import model.subsytem.RequestSystem;
import model.Request;

import java.util.ArrayList;

public class RequestController {
    private final RequestSystem requestSystem = new RequestSystem();
    public ArrayList<Request> requests;
    public Request request;

    public RequestController() {

    }

    // Lấy tất cả requests
    public ArrayList<Request> getAllRequests() {
        requests = requestSystem.selectAll();
        return requests;
    }

    // Lấy request bằng id
    public Request getRequestById(int res_id) {
        request = requestSystem.selectById(res_id);
        return request;
    }

    // Lấy các requets đang chờ xử lý
    public ArrayList<Request> getWaitRequests() {
        requests = requestSystem.selectByStatus("Chờ xử lý");
        return requests;
    }

    public void insert(Request request) {
        requestSystem.insert(request);
    }


    public static  void main (String[] args) {
        RequestController rc = new RequestController();
        OrderController oc = new OrderController();
        ArrayList<Order> orders = oc.getOrdersInRequest(1);
        for (Order o : orders) {
            System.out.println(o.getDesiredDate());
        }
    }

    // Update status
    public void updateStatus(int id, String status) {
        requestSystem.updateStatus(id, status);
    }

}
