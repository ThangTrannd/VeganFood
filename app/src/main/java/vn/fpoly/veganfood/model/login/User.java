package vn.fpoly.veganfood.model.login;

public class User {
    private String userName;
    private String password;
    private String email;
    private String avatar;
    private String address;
    private String phoneNumber;

    public User(String userName, String password, String email, String avatar, String address, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
