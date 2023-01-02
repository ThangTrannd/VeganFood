package vn.fpoly.veganfood.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductsByCategoryResult extends SimpleResult{
    @SerializedName("result")
    List<ProductsByCategoryResultModel> results;

    public void setResults(List<ProductsByCategoryResultModel> results) {
        this.results = results;
    }

    public List<ProductsByCategoryResultModel> getResults() {
        return results;
    }

}
