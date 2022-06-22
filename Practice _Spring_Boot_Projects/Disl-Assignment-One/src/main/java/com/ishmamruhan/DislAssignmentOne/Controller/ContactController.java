package com.ishmamruhan.DislAssignmentOne.Controller;

import com.ishmamruhan.DislAssignmentOne.Annotations.GetAPI;
import com.ishmamruhan.DislAssignmentOne.Annotations.PostAPI;
import com.ishmamruhan.DislAssignmentOne.Entity.ContactEntity.Contact;
import com.ishmamruhan.DislAssignmentOne.Entity.ContactEntity.ContactSearchCriteria;
import com.ishmamruhan.DislAssignmentOne.Output.Response;
import com.ishmamruhan.DislAssignmentOne.Service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @Operation(summary = "Welcome Message!")
    @GetAPI("/welcome")
    public ResponseEntity<Response> wecomeMessage(){

        return ResponseEntity.status(HttpStatus.OK).body(
          new Response<>(
                  HttpStatus.OK,
                  true,
                  "Api Fetch Success!",
                    "Welcome To Contact Controller!"
          )
        );
    }

    @Operation(
            summary = "Add a Contact",
            description = "Single Contact creation API. Mandatory Fields: \"Email, Firstname, Birthdate, Job Title, Company, Gender\"\n" +
                    "\n ** Date Format:  dd-MM-yyyy **"
    )
    @PostAPI("/add-contact")
    public ResponseEntity<Response> addContact(@Valid @RequestBody Contact contact){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Response<>(
                        HttpStatus.CREATED,
                        true,
                        "Contact creation Success!",
                        contactService.addContact(contact)
                )
        );
    }

    @Operation(
            summary = "Fetch/Search Contact",
            description = "All Params are optional. By default, you'll get all contacts.\n" +
                    "\n** Date format: dd-MM-yyyy **"
    )
    @GetAPI("/get")
    public ResponseEntity<Response<Object>> findContacts(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String zipcode,
            @RequestParam(required = false) Long startAge,
            @RequestParam(required = false) Long endAge,
            @RequestParam(required = false) String startBirthDate,
            @RequestParam(required = false) String endBirthDate
    ){

        ContactSearchCriteria contactSearchCriteria = new ContactSearchCriteria();
        contactSearchCriteria.setId(id);
        contactSearchCriteria.setFirstname(firstname);
        contactSearchCriteria.setLastname(lastname);
        contactSearchCriteria.setEmail(email);
        contactSearchCriteria.setCity(city);
        contactSearchCriteria.setZipcode(zipcode);
        contactSearchCriteria.setState(state);
        contactSearchCriteria.setStartAge(startAge);
        contactSearchCriteria.setEndAge(endAge);
        contactSearchCriteria.setStartBirthDate(startBirthDate);
        contactSearchCriteria.setEndBirthDate(endBirthDate);


        return ResponseEntity.status(HttpStatus.OK).body(
                new Response<Object>(
                        HttpStatus.OK,
                        true,
                        "Successfully fetched all data!",
                        contactService.findContacts(contactSearchCriteria)
                )
        );
    }


    

}
