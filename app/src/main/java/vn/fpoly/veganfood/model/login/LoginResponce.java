package vn.fpoly.veganfood.model.login;

public class LoginResponce {
    String message;
    String token;
    int status;

    public LoginResponce(String message, String token, int status) {
        this.message = message;
        this.token = token;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
