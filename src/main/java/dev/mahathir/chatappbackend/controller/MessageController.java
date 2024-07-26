package dev.mahathir.chatappbackend.controller;

import dev.mahathir.chatappbackend.dto.MessageDto;
import dev.mahathir.chatappbackend.entity.Message;
import dev.mahathir.chatappbackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestBody MessageDto messageDto) {
        return messageService.sendMessage(messageDto);
    }

    // get chat history of sender and receiver
    @GetMapping("/{senderPhoneNumber}/{recipientPhoneNumber}")
    public List<Message> getMessages(@PathVariable String senderPhoneNumber, @PathVariable String recipientPhoneNumber) {
        return messageService.getMessages(senderPhoneNumber, recipientPhoneNumber);
    }
}