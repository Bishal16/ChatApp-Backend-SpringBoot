package dev.mahathir.chatappbackend.repository;

import dev.mahathir.chatappbackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value =
            "select * from message where " +
            "(sender_phone_number = :sender_phoneNumber and recipient_phone_number = :recipient_phoneNumber) " +
            "or" +
            "(sender_phone_number = :recipient_phoneNumber and recipient_phone_number = :sender_phoneNumber)",
            nativeQuery = true
    )
    List<Message> findBySenderPhoneNumberOrRecipientPhoneNumber(String sender_phoneNumber, String recipient_phoneNumber);
}