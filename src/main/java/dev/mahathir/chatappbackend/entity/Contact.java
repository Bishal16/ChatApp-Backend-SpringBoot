package dev.mahathir.chatappbackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_phone_number", referencedColumnName = "phoneNumber")
    private User user;

    @ManyToOne
    @JoinColumn(name = "contact_phone_number", referencedColumnName = "phoneNumber")
    private User contact;
}