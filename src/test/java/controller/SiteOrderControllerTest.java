package controller;

import model.Order;
import model.SiteOrder;
import model.tabledata.MOChosenQuantity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SiteOrderControllerTest {
    private SiteOrderController siteOrderController = new SiteOrderController();
    Order order = new Order(1, 50, "30/05/2024", "note");

    private void checkData(ArrayList<SiteOrder> siteOrders, ArrayList<SiteOrder> expectedResults) {
        // Thay đổi phần kiểm tra kết quả
        for (int i = 0; i < siteOrders.size(); i++) {
            SiteOrder actual = siteOrders.get(i);
            SiteOrder expected = expectedResults.get(i);
            // Kiểm tra từng thuộc tính của SiteOrder
            assertEquals(expected.getId(), actual.getId(), "ID không khớp: Expected=" + expected.getId() + ", Actual=" + actual.getId());
            assertEquals(expected.getOrderId(), actual.getOrderId(), "Order ID không khớp: Expected=" + expected.getOrderId() + ", Actual=" + actual.getOrderId());
            assertEquals(expected.getSiteId(), actual.getSiteId(), "Site ID không khớp: Expected=" + expected.getSiteId() + ", Actual=" + actual.getSiteId());
            assertEquals(expected.getQuantity(), actual.getQuantity(), "Số lượng không khớp: Expected=" + expected.getQuantity() + ", Actual=" + actual.getQuantity());
            assertEquals(expected.getDeliveryType(), actual.getDeliveryType(), "Loại giao hàng không khớp: Expected=" + expected.getDeliveryType() + ", Actual=" + actual.getDeliveryType());
            assertEquals(expected.getPrice(), actual.getPrice(), "Giá không khớp: Expected=" + expected.getPrice() + ", Actual=" + actual.getPrice());
            assertEquals(expected.getStatus(), actual.getStatus(), "Trạng thái không khớp: Expected=" + expected.getStatus() + ", Actual=" + actual.getStatus());
            assertEquals(expected.getNote(), actual.getNote(), "Ghi chú không khớp: Expected=" + expected.getNote() + ", Actual=" + actual.getNote());
        }
    }

    @Test
    void getExpectedSiteOrdersWithNoChoice() {
        ArrayList<MOChosenQuantity> mocqs = new ArrayList<>();
        mocqs.addAll(Arrays.asList(
                new MOChosenQuantity(1, 0, "Đường thủy", 2000000, 21000000, 15),
                new MOChosenQuantity(2, 0, "Đường thủy", 2200000, 20500000, 20),
                new MOChosenQuantity(3, 0, "Đường thủy", 2500000, 19999000, 3),
                new MOChosenQuantity(4, 0, "Đường thủy", 1750000, 20750000, 24),
                new MOChosenQuantity(5, 0, "Đường thủy", 3000000, 20500000, 23),
                new MOChosenQuantity(6, 0, "Đường thủy", 2300000, 21200000, 42),
                new MOChosenQuantity(7, 0, "Đường thủy", 2150000, 21200000, 44),
                new MOChosenQuantity(8, 0, "Đường thủy", 2500000, 20100000, 11),
                new MOChosenQuantity(9, 0, "Đường thủy", 2450000, 20600000, 33),
                new MOChosenQuantity(10, 0, "Đường thủy", 2100000, 20800000, 14),
                new MOChosenQuantity(11, 0, "Đường thủy", 1900000, 20900000, 15),
                new MOChosenQuantity(12, 0, "Đường thủy", 2350000, 21200000, 11)
        ));
        ArrayList<SiteOrder> siteOrders = siteOrderController.getExpectedSiteOrders(mocqs, order);
        ArrayList<SiteOrder> expectedResults = new ArrayList<>();
        expectedResults.addAll(Arrays.asList(
                new SiteOrder(order.getId(), 3, 3, "Đường thủy", 62497000),
                new SiteOrder(order.getId(), 8, 11, "Đường thủy", 223600000),
                new SiteOrder(order.getId(), 2, 20, "Đường thủy", 412200000),
                new SiteOrder(order.getId(), 5, 16, "Đường thủy", 331000000)
        ));
        checkData(siteOrders, expectedResults);
    }

    @Test
    void getExpectedSiteOrdersHaveChoices() {
        ArrayList<MOChosenQuantity> mocqs = new ArrayList<>();
        mocqs.addAll(Arrays.asList(
                new MOChosenQuantity(1, 1, "Đường thủy", 2000000, 21000000, 15, true),
                new MOChosenQuantity(2, 0, "Đường thủy", 2200000, 20500000, 20),
                new MOChosenQuantity(3, 2, "Đường thủy", 2500000, 19999000, 3, true),
                new MOChosenQuantity(4, 0, "Đường thủy", 1750000, 20750000, 24),
                new MOChosenQuantity(5, 2, "Đường thủy", 3000000, 20500000, 23, true),
                new MOChosenQuantity(6, 3, "Đường thủy", 2300000, 21200000, 42, true),
                new MOChosenQuantity(7, 0, "Đường thủy", 2150000, 21200000, 44),
                new MOChosenQuantity(8, 0, "Đường thủy", 2500000, 20100000, 11),
                new MOChosenQuantity(9, 12, "Đường thủy", 2450000, 20600000, 33, true),
                new MOChosenQuantity(10, 0, "Đường thủy", 2100000, 20800000, 14),
                new MOChosenQuantity(11, 10, "Đường thủy", 1900000, 20900000, 15, true),
                new MOChosenQuantity(12, 0, "Đường thủy", 2350000, 21200000, 11)
        ));
        ArrayList<SiteOrder> siteOrders = siteOrderController.getExpectedSiteOrders(mocqs, order);
        ArrayList<SiteOrder> expectedResults = new ArrayList<>();
        expectedResults.addAll(Arrays.asList(
                new SiteOrder(order.getId(), 1, 1, "Đường thủy", 23000000),
                new SiteOrder(order.getId(), 3, 2, "Đường thủy", 42498000),
                new SiteOrder(order.getId(), 5, 2, "Đường thủy", 44000000),
                new SiteOrder(order.getId(), 6, 3, "Đường thủy", 65900000),
                new SiteOrder(order.getId(), 9, 12, "Đường thủy", 249650000),
                new SiteOrder(order.getId(), 11, 10, "Đường thủy", 210900000),
                new SiteOrder(order.getId(), 8, 11, "Đường thủy", 223600000),
                new SiteOrder(order.getId(), 2, 9, "Đường thủy", 186700000)

                ));
        checkData(siteOrders, expectedResults);
    }

    @Test
    void getExpectedSiteOrdersHaveChoicesAndDelivery() {
        ArrayList<MOChosenQuantity> mocqs = new ArrayList<>();
        mocqs.addAll(Arrays.asList(
                new MOChosenQuantity(1, 10, "Hàng không", 4000000, 21000000, 15, true),
                new MOChosenQuantity(2, 0, "Đường thủy", 2200000, 20500000, 20),
                new MOChosenQuantity(3, 2, "Hàng không", 4500000, 19999000, 3, true),
                new MOChosenQuantity(4, 0, "Đường thủy", 1750000, 20750000, 24),
                new MOChosenQuantity(5, 6, "Hàng không", 6000000, 20500000, 23, true),
                new MOChosenQuantity(6, 0, "Đường thủy", 2300000, 21200000, 42),
                new MOChosenQuantity(7, 0, "Đường thủy", 2150000, 21200000, 44),
                new MOChosenQuantity(8, 0, "Đường thủy", 2500000, 20100000, 11),
                new MOChosenQuantity(9, 12, "Hàng không", 4950000, 20600000, 33, true),
                new MOChosenQuantity(10, 5, "Đường thủy", 2100000, 20800000, 14, true),
                new MOChosenQuantity(11, 0, "Đường thủy", 1900000, 20900000, 15),
                new MOChosenQuantity(12, 0, "Đường thủy", 2350000, 21200000, 11)
        ));
        ArrayList<SiteOrder> siteOrders = siteOrderController.getExpectedSiteOrders(mocqs, order);
        ArrayList<SiteOrder> expectedResults = new ArrayList<>();
        expectedResults.addAll(Arrays.asList(
                new SiteOrder(order.getId(), 1, 10, "Hàng không", 214000000),
                new SiteOrder(order.getId(), 3, 2, "Hàng không", 44498000),
                new SiteOrder(order.getId(), 5, 6, "Hàng không", 129000000),
                new SiteOrder(order.getId(), 9, 12, "Hàng không", 252150000),
                new SiteOrder(order.getId(), 10, 5, "Đường thủy", 106100000),
                new SiteOrder(order.getId(), 8, 11, "Đường thủy", 223600000),
                new SiteOrder(order.getId(), 2, 4, "Đường thủy", 84200000)
        ));
        checkData(siteOrders, expectedResults);
    }

}
