package model;

public class Product {
    private int id;
    private String name;
    private String prime;
    private String quantity;
    private String color;
    private String status;
    Category category = new Category();

    public Product(int id, String name, String prime, String quantity, String color, String status, Category category) {
        this.id = id;
        this.name = name;
        this.prime = prime;
        this.quantity = quantity;
        this.color = color;
        this.status = status;
        this.category = category;
    }

    public Product(int id, String name, String prime, String quantity, String color, String status) {
        this.id = id;
        this.name = name;
        this.prime = prime;
        this.quantity = quantity;
        this.color = color;
        this.status = status;
    }

    public Product(String name, String price, String quantity, String color, String status) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
