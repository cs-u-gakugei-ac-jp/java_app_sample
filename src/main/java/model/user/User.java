package model.user;

import model.Default;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class User extends Default {
    // TODO: encapsulation
    public String name;
    public String email;
    public String password;

    public User(
        String id,
        Timestamp createdAt,
        Timestamp updatedAt,
        String name,
        String email,
        String password
    ) {
        // TODO: addition of validation process
        // 親（スーパー）クラスのコンストラクタを呼び出す
        super(id, createdAt, updatedAt);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void createUser() {
        this.hashPassword();
        Repository.insertUser(this);
    }

    public void hashPassword() {
        this.password = getHash(this.email, this.password);
    }

    private String getHash(String email, String password) {
        final String HASH_ALGORITHM = "SHA-256";
        final int STRETCH_COUNT = 1024;
        final String FIXED_SALT = "vBjRGHZ6awqJL9JDQuNftAzaPSnHszQN";

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String salt = email + FIXED_SALT;
        messageDigest.update(salt.getBytes());
        byte[] hashed = messageDigest.digest(password.getBytes());

        for (int i = 0; i < STRETCH_COUNT; i++) {
            hashed = messageDigest.digest(hashed);
        }

        return getHexString(hashed);
    }

    private String getHexString(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(Integer.toHexString((bytes[i] >> 4) & 0x0f));
            stringBuffer.append(Integer.toHexString(bytes[i] & 0x0f));
        }

        return stringBuffer.toString();
    }
}
