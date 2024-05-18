package model;

public class Order {
    private int id;
    private int productId;
    private int quantity;
    private String unit;
    private String desiredDate;
    private String status;
    private String note;
    private int requestId;

    private Product product;
    private String productName;

    public Order(int id, Product product, int quantity, String unit, String desiredDate, String status, String note) {
        this.id = id;
        this.product = product;
        this.productId = product.getId();
        this.productName = product.getName();
        this.quantity = quantity;
        this.unit = unit;
        this.desiredDate = desiredDate;
        this.status = status;
        this.note = note;
    }

    public Order() {
    }

    public Order(int id, int productId, int quantity, String unit, String desiredDate, String status, String note, int requestId) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.unit = unit;
        this.desiredDate = desiredDate;
        this.status = status;
        this.note = note;
        this.requestId = requestId;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getDesiredDate() {
        return desiredDate;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public int getRequestId() {
        return requestId;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductName() {
        return productName;
    }
}
