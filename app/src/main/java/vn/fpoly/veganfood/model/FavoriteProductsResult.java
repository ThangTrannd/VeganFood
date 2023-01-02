package vn.fpoly.veganfood.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FavoriteProductsResult extends SimpleResult{
    @SerializedName("result")
    List<FavoriteProductsResultModel> results;

    public List<FavoriteProductsResultModel> getResults() {
        return results;
    }


    public class  FavoriteProductsResultModel {
        @SerializedName("id")
        int id;
        @SerializedName("productId")
        int productId;
        @SerializedName("productName")
        String productName;
        @SerializedName("productDescription")
        String productDescription;
        @SerializedName("productCategoryName")
        String productCategoryName;
        @SerializedName("quantity")
        int quantity;
        @SerializedName("price")
        String price;
        @SerializedName("discount")
        String discount;
        @SerializedName("discountPercent")
        String discountPercent;
        @SerializedName("priceAfterDiscount")
        String priceAfterDiscount;
        @SerializedName("size")
        String size;
        @SerializedName("displayImage")
        String displayImage;
        @SerializedName("priceBeforeDiscount")
        String priceBeforeDiscount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public String getProductCategoryName() {
            return productCategoryName;
        }

        public void setProductCategoryName(String productCategoryName) {
            this.productCategoryName = productCategoryName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscountPercent() {
            return discountPercent;
        }

        public void setDiscountPercent(String discountPercent) {
            this.discountPercent = discountPercent;
        }

        public String getPriceAfterDiscount() {
            return priceAfterDiscount;
        }

        public void setPriceAfterDiscount(String priceAfterDiscount) {
            this.priceAfterDiscount = priceAfterDiscount;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getDisplayImage() {
            return displayImage;
        }

        public void setDisplayImage(String displayImage) {
            this.displayImage = displayImage;
        }

        public String getPriceBeforeDiscount() {
            return priceBeforeDiscount;
        }

        public void setPriceBeforeDiscount(String priceBeforeDiscount) {
            this.priceBeforeDiscount = priceBeforeDiscount;
        }
    }
}
