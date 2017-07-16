package com.teddywidom.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String encryptedPassword;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @CreationTimestamp
    private Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());

    @NotNull
    @UpdateTimestamp
    private Timestamp updatedAt = Timestamp.valueOf(LocalDateTime.now());

    protected User() {
    }

    public User(String firstName, String lastName, String username, String encryptedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
