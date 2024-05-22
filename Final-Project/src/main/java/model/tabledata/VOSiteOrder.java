package model.tabledata;

import controller.OrderController;
import controller.ProductController;
import controller.SiteController;
import controller.SiteProductController;
import model.SiteOrder;
import model.Order;
import model.SiteProduct;

public class VOSiteOrder {
    private static int iDCounter = 1;
    private int id;
    private int siteOrderID;
    private String siteName;
    private String productName;
    private int quantity;
    private String unit;
    private double productPrice;
    private String deliveryType;
    private double deliveryPrice;
    private String status;
    private String note;
    private int siteProductID;
    private final SiteController siteController = new SiteController();

    private final ProductController productController = new ProductController();
    private final OrderController orderController = new OrderController();
    private final SiteProductController siteProductController = new SiteProductController();
    public VOSiteOrder(SiteOrder siteOrder){
        this.id = iDCounter++;
        this.siteOrderID = siteOrder.getId();
        this.siteName = siteController.getSiteById(siteOrder.getSiteId()).getName();
        this.quantity = siteOrder.getQuantity();
        Order order = orderController.getOrderById(siteOrder.getOrderId());
        this.productName = productController.getProductById(order.getProductId()).getName();
        this.unit = order.getUnit();
        this.productPrice = siteProductController.getSiteproductFromProductAndSite(order.getProductId(),siteOrder.getSiteId()).getPrice();
        this.deliveryType = siteOrder.getDeliveryType();
        this.deliveryPrice = siteOrder.getPrice() - siteOrder.getQuantity()*siteProductController.getSiteproductFromProductAndSite(order.getProductId(),siteOrder.getSiteId()).getPrice();
        this.status = siteOrder.getStatus();
        this.note = siteOrder.getNote();
        this.siteProductID = siteProductController.getSiteproductFromProductAndSite(order.getProductId(),siteOrder.getSiteId()).getId();
    }
    public int getId() {
        return id;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public String getStatus() {
        return status;
    }
    public String getNote(){
        return note;
    }
    public static void setiDCounter(int iDCounter){
        VOSiteOrder.iDCounter = iDCounter;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public int getSiteProductID(){
        return siteProductID;
    }
    public int getSiteOrderID(){
        return siteOrderID;
    }
}
