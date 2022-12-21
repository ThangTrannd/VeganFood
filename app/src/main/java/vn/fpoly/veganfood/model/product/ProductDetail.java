package vn.fpoly.veganfood.model.product;

public class ProductDetail {
    String description;
    String created;
    int importPrice;
    String supplier;
    int quantityProduc;
    String expirydate;

    public ProductDetail(String description, String created, int importPrice, String supplier, int quantityProduc, String expirydate) {
        this.description = description;
        this.created = created;
        this.importPrice = importPrice;
        this.supplier = supplier;
        this.quantityProduc = quantityProduc;
        this.expirydate = expirydate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQuantityProduc() {
        return quantityProduc;
    }

    public void setQuantityProduc(int quantityProduc) {
        this.quantityProduc = quantityProduc;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }
}
