package vn.fpoly.veganfood.model.login;

public class RegisterData {
    private String userName;
    private String password;
    private String email;
    private String avatar;
    private String address;
    private String phone;
    private String dateuser;

    public RegisterData(String userName, String password, String email, String avatar, String address, String phone, String dateuser) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.dateuser = dateuser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateuser() {
        return dateuser;
    }

    public void setDateuser(String dateuser) {
        this.dateuser = dateuser;
    }
}
