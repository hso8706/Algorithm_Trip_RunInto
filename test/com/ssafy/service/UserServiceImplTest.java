package com.ssafy.service;

import static org.junit.jupiter.api.Assertions.*;

import com.ssafy.vo.Attraction;
import com.ssafy.vo.User;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {


    UserServiceImpl service=new UserServiceImpl();
    @Test
    void check() throws NoSuchAlgorithmException {

        User[] testUser = new User[4];

        for (int i = 0; i < 4; i++) {
            testUser[i] = new User(""+i, "pw"+i, "salt"+i);
            String password = testUser[i].getPass(); // 암호화할 비밀번호(유저의 입력)
            String salt = testUser[i].getSalt(); // 임의의 솔트값, 유저마다 고유하게 설정

            assertEquals(service.hashPassword(password, salt),service.hashPassword("pw"+i, "salt"+i));
        }
    }
}