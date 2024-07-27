package dev.mahathir.chatappbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String username;

    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private String password;

    private String imageUrl;
}
