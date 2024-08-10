package dev.mahathir.chatappbackend.dto;


import lombok.Data;

@Data
public class UserDto {
    private String phoneNumber;
//    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String imageUrl;
}