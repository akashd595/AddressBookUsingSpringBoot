package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.DTO.ContactDTO;
import com.bridgelabz.AddressBookApp.exception.CustomException;
import com.bridgelabz.AddressBookApp.model.ContactData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements com.bridgelabz.AddressBookApp.service.IAddessBookService {
    @Autowired
    com.bridgelabz.AddressBookApp.repository.AddressBookRepository addressBookRepository;

    @Autowired
    com.bridgelabz.AddressBookApp.service.EmailService emailService;

    public ContactData addContact(ContactDTO contactDTO){
        ContactData contactData = new ContactData(contactDTO);    //contactData is entity
//        emailService.sendEmail(contactDTO.getEmail(), "Account Sign-up Successfully", "Hello "+contactDTO.getName()+" Your name added successfully");
        return addressBookRepository.save(contactData);
    }
    public Optional<ContactData> findContactID(int id){
        if(addressBookRepository.findById(id).isPresent()){
            return addressBookRepository.findById(id);
        }else {
            throw new CustomException("Contact with "+id+" id is not found in the Address Book");
        }
    }

    public List<ContactData> findContactbyName(String name){
        if(addressBookRepository.findUsingName(name).isEmpty()){
            throw new CustomException(name+" is not found in the Address Book");
        }else {
            return addressBookRepository.findUsingName(name);
        }
    }
    public ContactData updateContactID(com.bridgelabz.AddressBookApp.DTO.ContactDTO contactDTO, int id){
        if(addressBookRepository.findById(id).isPresent()) {
            ContactData contactData = addressBookRepository.findById(id).get();
            contactData.setName(contactDTO.getName());
            contactData.setAddress(contactDTO.getAddress());
            return addressBookRepository.save(contactData);
        }else{
            throw new CustomException("Contact with "+id+" id is not found");
        }
    }
    public Integer deleteEmployeeID(int id) {
        if (addressBookRepository.findById(id).isPresent()) {
            addressBookRepository.deleteById(id);
            return id;
        }else{
            throw new CustomException("Contact with "+id+" id is not found");
        }
    }
    public List<ContactData> findAllContacts(){
        if(!addressBookRepository.findAll().isEmpty()){
            return addressBookRepository.findAll();
        }else {
            throw new CustomException("Table is Empty");
        }
    }
}
