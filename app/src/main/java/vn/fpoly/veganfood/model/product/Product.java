package vn.fpoly.veganfood.model.product;

public class Product {
    private int image;
    private String name;
    private int gam;
    private int price;


    public Product() {
    }

    public Product(int image, String name, int gam, int price) {
        this.image = image;
        this.name = name;
        this.gam = gam;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGam() {
        return gam;
    }

    public void setGam(int gam) {
        this.gam = gam;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
