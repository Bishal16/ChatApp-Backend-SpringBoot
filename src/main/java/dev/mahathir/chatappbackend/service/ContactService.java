package dev.mahathir.chatappbackend.service;

import dev.mahathir.chatappbackend.dto.ContactDto;
import dev.mahathir.chatappbackend.entity.Contact;
import dev.mahathir.chatappbackend.entity.User;
import dev.mahathir.chatappbackend.repository.ContactRepository;
import dev.mahathir.chatappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    public Contact addContact(ContactDto contactDto) {
        if(contactRepository.findByUserPhoneNumberAndContactPhoneNumber(contactDto.getUserPhoneNumber() ,contactDto.getContactPhoneNumber()).isPresent()){
            throw new RuntimeException("Contact with phone number " + contactDto.getContactPhoneNumber() + " already added.");
        }

        Optional<User> user = userRepository.findById(contactDto.getUserPhoneNumber());
        Optional<User> contactUser = userRepository.findById(contactDto.getContactPhoneNumber());

        if (user.isPresent() && contactUser.isPresent()) {
            Contact contact = new Contact();
            contact.setUser(user.get());
            contact.setContact(contactUser.get());
            return contactRepository.save(contact);
        } else {
            throw new RuntimeException("User or Contact not found");
        }
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}