package model;

public class SiteProduct {
    private Product product;
    private double price;
    private int quantity;
    private int soldQuantity;

    public SiteProduct(Product product, double price, int quantity, int soldQuantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }
}
