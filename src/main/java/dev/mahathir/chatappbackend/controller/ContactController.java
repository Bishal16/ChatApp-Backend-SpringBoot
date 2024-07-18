package dev.mahathir.chatappbackend.controller;

import dev.mahathir.chatappbackend.dto.ContactDto;
import dev.mahathir.chatappbackend.model.Contact;
import dev.mahathir.chatappbackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact addContact(@RequestBody ContactDto contactDto) {
        return contactService.addContact(contactDto);
    }
}