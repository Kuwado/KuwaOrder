package controller;

import model.Order;
import model.SiteOrder;
import model.subsytem.SiteOrderSystem;
import model.tabledata.MOChosenQuantity;
import solution.TotalPriceComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SiteOrderController {
    private final SiteOrderSystem siteOrderSystem = new SiteOrderSystem();
    public ArrayList<SiteOrder> siteOrders;
    public SiteOrder siteOrder;

    public SiteOrderController() {

    }

    public void insert(SiteOrder siteOrder) {
        siteOrderSystem.insert(siteOrder);
    }

    // Lấy tất cả siteOrders
    public ArrayList<SiteOrder> getAllSiteOrders() {
        siteOrders = siteOrderSystem.selectAll();
        return siteOrders;
    }

    // Lấy siteOrder bằng id
    public SiteOrder getSiteOrderById(int siteOrder_id) {
        siteOrder = siteOrderSystem.selectById(siteOrder_id);
        return siteOrder;
    }

    public  ArrayList<SiteOrder> getExpectedSiteOrders(ArrayList<MOChosenQuantity> sites, Order order) {
        ArrayList<SiteOrder> makeSiteOrders = new ArrayList<>();
        int number = order.getQuantity();
        List<MOChosenQuantity> sitesToRemove = new ArrayList<>();
        // Lọc những site đã được chọn
        for(MOChosenQuantity chosenQuantity : sites) {
            if (chosenQuantity.isStt()) {
                number -= chosenQuantity.getChosenQuantity();
                double price = chosenQuantity.getProductPrice()*chosenQuantity.getChosenQuantity() + chosenQuantity.getDeliveryPrice();
                makeSiteOrders.add(new SiteOrder(order.getId(), chosenQuantity.getSiteId(), chosenQuantity.getChosenQuantity(), chosenQuantity.getDeliveryType(), price));
                sitesToRemove.add(chosenQuantity);
            }
        }

        if (!sitesToRemove.isEmpty()) {
            sites.removeAll(sitesToRemove);
        }

        if (number > 0) {
            // Sắp xếp lại những site còn lại
            Comparator<MOChosenQuantity> totalPriceComparator = new TotalPriceComparator(number);
            sites.sort(totalPriceComparator);
            for (MOChosenQuantity chosenQuantity : sites) {
                if (chosenQuantity.getQuantity() >= number) {
                    double price = chosenQuantity.getProductPrice()*number + chosenQuantity.getDeliveryPrice();
                    makeSiteOrders.add(new SiteOrder(order.getId(), chosenQuantity.getSiteId(), number, chosenQuantity.getDeliveryType(), price));
                    break;
                } else {
                    double price = chosenQuantity.getProductPrice()*chosenQuantity.getQuantity() + chosenQuantity.getDeliveryPrice();
                    makeSiteOrders.add(new SiteOrder(order.getId(), chosenQuantity.getSiteId(), chosenQuantity.getQuantity(), chosenQuantity.getDeliveryType(), price));
                    number -= chosenQuantity.getQuantity();
                }
            }
        }
        return makeSiteOrders;
    }

    // Update status
    public void updateStatus(int id, String status) {
        siteOrderSystem.updateStatus(id, status);
    }

}
