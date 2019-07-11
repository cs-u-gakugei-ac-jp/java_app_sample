package model;

import java.sql.Timestamp;

public class Default {
    // TODO: encapsulation
    public String id;
    public Timestamp createdAt;
    public Timestamp updatedAt;

    public Default(String id, Timestamp createdAt, Timestamp updatedAt) {
        // TODO: addition of validation process
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
}
