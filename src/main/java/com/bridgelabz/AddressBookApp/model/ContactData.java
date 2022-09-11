package com.bridgelabz.AddressBookApp.model;

import com.bridgelabz.AddressBookApp.DTO.ContactDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class ContactData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contactId;
    private String name;
    private String address;
    private String city;
    @ElementCollection
    @CollectionTable(name = "phone_Number_list", joinColumns = @JoinColumn(name = "contact_id"))
    public List<String> phoneNumber;

    public ContactData() {
    }

    public ContactData(ContactDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.address = employeeDTO.getAddress();
        this.phoneNumber = employeeDTO.getPhoneNumber();
        this.city = employeeDTO.getCity();
    }

    public ContactData(int contactId, String name, String address, String note, List<String> phoneNumber) {
        this.contactId = contactId;
        this.name = name;
        this.address = address;
        this.city = note;
        this.phoneNumber = phoneNumber;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int employeeId) {
        this.contactId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> department) {
        this.phoneNumber = department;
    }
}