package dao.interfaces;

import dao.entities.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll();
    List<Contact> findAllWithDetails();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
