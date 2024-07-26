package dev.mahathir.chatappbackend.repository;

import dev.mahathir.chatappbackend.entity.Contact;
import dev.mahathir.chatappbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
    Optional<Contact> findByUserPhoneNumberAndContactPhoneNumber(String UserPhoneNumber, String ContactPhoneNumber);
    List<Contact> findByUserPhoneNumber(String UserPhoneNumber);
}