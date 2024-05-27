package model.tabledata;

import controller.*;
import javafx.scene.control.Button;
import model.SiteOrder;
import model.Site;

public class WHSiteOrder {
    private static int idCounter = 1;
    private int id;
    private SiteOrder siteOrder;
    private String maDonHang;
    private String site;
    private String phuongThuc;
    private String trangThai;
    private String note;
    private double price;
    private Button action;


//    SiteOrder sod = siteOrderController.getSiteOrderById(selectedOrder.getId());
    private final SiteController siteController = new SiteController();
    private final SiteOrderController siteOrderController = new SiteOrderController();
    public WHSiteOrder(SiteOrder siteOrder, Button action) {
        Site s = siteController.getSiteById(siteOrder.getSiteId());
        this.id = idCounter++;
        this.siteOrder = siteOrder;
        this.maDonHang = String.valueOf(siteOrder.getId());
        this.site = String.valueOf(s.getName());
        this.phuongThuc = siteOrder.getDeliveryType();
        this.trangThai = siteOrder.getStatus();
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public SiteOrder getSiteOrder() {
        return siteOrder;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public String getSite() {
        return site;
    }

    public String getPhuongThuc() {
        return phuongThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getNote() {
        return note;
    }

    public double getPrice() {
        return price;
    }

    public Button getAction() {
        return action;
    }

    public static void resetIdCounter() {
        idCounter = 1;
    }
}
