package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.DTO.ContactDTO;
import com.bridgelabz.AddressBookApp.DTO.ResponseDTO;
import com.bridgelabz.AddressBookApp.model.ContactData;
import com.bridgelabz.AddressBookApp.service.IAddessBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Controller  class
 */

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    /**
     * Auto wired with Service class
     */
    @Autowired
    IAddessBookService iAddressBookService;

    @PostMapping("/addContact")
    public ResponseEntity<ResponseDTO> createContact( @Valid @RequestBody ContactDTO contactDTO ){
        ResponseDTO responseDTO = new ResponseDTO("Contact Added Successfully", iAddressBookService.addContact ( contactDTO ));
        return new ResponseEntity<>( responseDTO, HttpStatus.CREATED );
    }

    /**
     * Finding employee using its ID
     */
    @GetMapping("/findContactByID/{id}")
    public ResponseEntity<ResponseDTO> findContact(@PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("ID found", iAddressBookService.findContactID( id ));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
    }

    @GetMapping("/findContactByName/{name}")
    public ResponseEntity<ResponseDTO> findContactName( @PathVariable String name ){
        ResponseDTO responseDTO = new ResponseDTO("Contact found", iAddressBookService.findContactbyName(name));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
    }

    @DeleteMapping("deleteContact/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Succfully deleted", iAddressBookService.deleteEmployeeID( id ));
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    /**
     * Updating Employee Using its ID
     * */
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDTO> UpdateContact(@Valid @RequestBody ContactDTO employeeDTO, @PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("Updated", iAddressBookService.updateContactID( employeeDTO, id ));
        if(iAddressBookService.updateContactID( employeeDTO, id ) != null){
            return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
        }
        responseDTO.setMessage("ID not found");
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findAllContact")
    public List<ContactData> findAllContact(){
        return iAddressBookService.findAllContacts();
    }
}
