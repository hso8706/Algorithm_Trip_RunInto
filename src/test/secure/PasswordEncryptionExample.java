package test.secure;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptionExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "userPassword123"; // 암호화할 비밀번호(유저의 입력)
        String salt = "randomSalt"; // 임의의 솔트값, 유저마다 고유하게 설정

        String hashedPassword = hashPassword(password, salt); // 비밀번호 암호화 메서드

        // 암호화된 비밀번호와 솔트 출력
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Salt: " + salt);
    }

    // 비밀번호 해시 함수
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = salt + password; // salt와 유저의 비밀번호를 결합
            /*
            ### MessageDigest
            - MD5, SHA 알고리즘을 이용하기 위한 객체
            - .getInstance("SHA-256")를 통해서 SHA-256 사용 객체를 호출
            - .digest()를 통해 암호화 실행

            ### String.getBytes(StandardCharsets.UTF_8)
            - 문자열을 인자로 제공한 Charset으로 인코딩, 즉 바이트코드로 변환해주는 메서드
            */
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // SHA-256 알고리즘 객체 호출
        byte[] hashedPassword = messageDigest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashedPassword);
    }

    // 바이트 배열을 16진수 문자열로 변환하는 메서드
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xff);
            if (hex.length() == 1) {
                sb.append("0");
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}