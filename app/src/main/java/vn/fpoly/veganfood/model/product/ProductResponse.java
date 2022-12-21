package vn.fpoly.veganfood.model.product;

import java.util.List;

public class ProductResponse {
    private ProductDetail productinformation;
    private List<String> imageProduct;
    private String name;
    private int price;
    private int idCategory;

    public ProductResponse(ProductDetail productinformation, List<String> imageProduct, String name, int price, int idCategory) {
        this.productinformation = productinformation;
        this.imageProduct = imageProduct;
        this.name = name;
        this.price = price;
        this.idCategory = idCategory;
    }

    public ProductDetail getProductinformation() {
        return productinformation;
    }

    public void setProductinformation(ProductDetail productinformation) {
        this.productinformation = productinformation;
    }

    public List<String> getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(List<String> imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
