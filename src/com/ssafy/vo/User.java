package com.ssafy.vo;

public class User {

    private String id;
    private String pass;

    private String salt;

    public User(String id, String pass, String salt) {
        this.id = id;
        this.pass = pass;
        this.salt = salt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
