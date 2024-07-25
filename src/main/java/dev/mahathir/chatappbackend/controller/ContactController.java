package dev.mahathir.chatappbackend.controller;

import dev.mahathir.chatappbackend.dto.ContactDto;
import dev.mahathir.chatappbackend.entity.Contact;
import dev.mahathir.chatappbackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    // create a contact
    @PostMapping
    public Contact addContact(@RequestBody ContactDto contactDto) {
        return contactService.addContact(contactDto);
    }

    // get all contacts
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }
}