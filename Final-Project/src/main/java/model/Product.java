package model;

public class Product {
    private int id;
    private String name;
    private String image;
    private String category;
    private String description;

    public Product() {
    }

    public Product(int id, String name, String image, String category, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }
}


