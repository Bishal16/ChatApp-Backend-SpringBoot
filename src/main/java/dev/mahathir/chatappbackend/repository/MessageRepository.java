package dev.mahathir.chatappbackend.repository;

import dev.mahathir.chatappbackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderPhoneNumberAndRecipientPhoneNumber(String sender_phoneNumber, String recipient_phoneNumber);
}