package com.example.de24cuoiki;

public class user {
    private String id;
    private String email;
    private String taiKhoan;
    private String matKhau;

    public user(String id, String email, String taiKhoan, String matKhau) {
        this.id = id;
        this.email = email;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
