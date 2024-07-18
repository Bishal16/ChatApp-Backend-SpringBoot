package dev.mahathir.chatappbackend.entity;

import jakarta.persistence.*;

//import javax.persistence.*;
import java.util.Set;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "sender")
    private Set<Message> sentMessages;

    @OneToMany(mappedBy = "recipient")
    private Set<Message> receivedMessages;

    // Getters and Setters
}