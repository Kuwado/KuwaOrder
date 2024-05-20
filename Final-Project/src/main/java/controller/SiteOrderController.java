package controller;

import model.SiteOrder;
import model.subsytem.SiteOrderSystem;

import java.util.ArrayList;

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
}
