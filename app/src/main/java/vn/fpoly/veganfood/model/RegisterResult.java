package vn.fpoly.veganfood.model;

import com.google.gson.annotations.SerializedName;

public class RegisterResult extends SimpleResult{
    @SerializedName("result")
    boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
