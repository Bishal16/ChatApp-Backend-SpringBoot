package dev.mahathir.chatappbackend.dto;

import lombok.Data;

@Data
public class MessageDto {
    private String senderPhoneNumber;
    private String recipientPhoneNumber;
    private String content;
}