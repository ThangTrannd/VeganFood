package vn.fpoly.veganfood.activity.home.adapter;

public class Category {
    private int image;
    private String catego;

    public Category(int image, String catego) {
        this.image = image;
        this.catego = catego;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCatego() {
        return catego;
    }

    public void setCatego(String catego) {
        this.catego = catego;
    }
}
