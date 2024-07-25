package dev.mahathir.chatappbackend.service;

import dev.mahathir.chatappbackend.dto.MessageDto;
import dev.mahathir.chatappbackend.entity.Message;
import dev.mahathir.chatappbackend.entity.User;
import dev.mahathir.chatappbackend.repository.MessageRepository;
import dev.mahathir.chatappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public Message sendMessage(MessageDto messageDto) {
        User sender = userRepository.findById(messageDto.getSenderPhoneNumber())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        User recipient = userRepository.findById(messageDto.getRecipientPhoneNumber())
                .orElseThrow(() -> new RuntimeException("Recipient not found"));

        Message message = new Message();
        message.setSender(sender);
        message.setRecipient(recipient);
        message.setContent(messageDto.getContent());
        message.setTimestamp(LocalDateTime.now());

        return messageRepository.save(message);
    }

    public List<Message> getMessages(String senderId, Long recipientId) {
        return messageRepository.findBySenderPhoneNumberAndRecipientPhoneNumber(senderId, String.valueOf(recipientId));
    }
}