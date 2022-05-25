package model;


public class Product {
    private int p_id;
    private String p_name, image;
    private double price; // gia sp
    private String title, discription; // nd va mieu ta sp

    public Product() {
    }

    public Product(int p_id, String p_name, String image, double price, String title, String discription) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.discription = discription;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }
    public String getPriceFomat(){
        return String.format("%.3f", this.price)+ "VNĐ";
    }
    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "Product{" + "p_name=" + p_name + '}';
    }

    

   
}
