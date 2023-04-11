package com.ssafy.test.secure;

public class TestUserInfo {
    int userId;
    String pw;
    String salt;

    public TestUserInfo(int userId, String pw, String salt) {
        this.userId = userId;
        this.pw = pw;
        this.salt = salt;
    }
}
