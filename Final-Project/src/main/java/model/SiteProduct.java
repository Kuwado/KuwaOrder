package model;

public class SiteProduct {
    private int id;
    private int siteId;
    private int productId;
    private int quantity;
    private int soldQuantity;
    private double price;

    private Product product;


    public SiteProduct(Product product, double price, int quantity, int soldQuantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
    }

    public SiteProduct() {
    }

    public SiteProduct(int id, int siteId, int productId, int quantity, int soldQuantity, double price) {
        this.id = id;
        this.siteId = siteId;
        this.productId = productId;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getSiteId() {
        return siteId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setSoldQuantity(int soldQuantity){
        this.soldQuantity = soldQuantity;
    }

}
