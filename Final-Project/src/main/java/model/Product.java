package model;

public class Product {
    public int id;
    public String name;
    public String description;
    public String image;
    public double price;
    public double discount_price;
    public String category;

    public Product(int id, String name, String description, String image, double price, double discount_price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.discount_price = discount_price;
        this.category = category;
    }
}


