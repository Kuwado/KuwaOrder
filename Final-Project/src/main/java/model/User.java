package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String type;
    private String image;

    public User(int id, String name, String email, String password, String type, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.image = image;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }
}
