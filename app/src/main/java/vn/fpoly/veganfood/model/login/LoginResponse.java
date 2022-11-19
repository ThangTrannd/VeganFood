package vn.fpoly.veganfood.model.login;

public class LoginResponse {
    String message;
    String token;
    String status;

    public LoginResponse(String message, String token, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
