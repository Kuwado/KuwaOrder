package model;

public class SiteProduct {
    private int product_id;
    private String product_name;
    private int quantity;
    private int sold_quantity;

    public SiteProduct(int product_id, String product_name, int quantity, int sold_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.sold_quantity = sold_quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSold_quantity() {
        return sold_quantity;
    }
}
