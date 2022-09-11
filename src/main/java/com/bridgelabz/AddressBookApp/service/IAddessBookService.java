package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.model.ContactData;

import java.util.List;
import java.util.Optional;

public interface IAddessBookService {


    public ContactData addContact(com.bridgelabz.AddressBookApp.DTO.ContactDTO greetingDTO);
    public ContactData updateContactID(com.bridgelabz.AddressBookApp.DTO.ContactDTO employeeDTO, int id);

    public Optional<ContactData> findContactID(int id);
    public List<ContactData> findContactbyName(String name);
    public Integer deleteEmployeeID(int id);

    public List<ContactData> findAllContacts();
}
