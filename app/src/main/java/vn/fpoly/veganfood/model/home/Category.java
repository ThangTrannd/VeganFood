package vn.fpoly.veganfood.model.home;

import java.util.List;

public class Category {
    private String categoryname;
    private List<String> imagecategory;
    private int filter;

    public Category(String categoryname, List<String> imagecategory, int filter) {
        this.categoryname = categoryname;
        this.imagecategory = imagecategory;
        this.filter = filter;
    }


    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public List<String> getImagecategory() {
        return imagecategory;
    }

    public void setImagecategory(List<String> imagecategory) {
        this.imagecategory = imagecategory;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }
}
