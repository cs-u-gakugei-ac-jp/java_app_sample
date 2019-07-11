package model.user;

import model.Default;

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
}
