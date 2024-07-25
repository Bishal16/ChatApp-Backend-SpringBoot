package dev.mahathir.chatappbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_phone_number", referencedColumnName = "phoneNumber")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "recipient_phone_number", referencedColumnName = "phoneNumber")
    private User recipient;


    private String content;
    private LocalDateTime timestamp;
}