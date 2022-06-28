package com.ishmamruhan.DislAssignmentOne.Controller;

import com.ishmamruhan.DislAssignmentOne.Annotations.DeleteAPI;
import com.ishmamruhan.DislAssignmentOne.Annotations.GetAPI;
import com.ishmamruhan.DislAssignmentOne.Annotations.PostAPI;
import com.ishmamruhan.DislAssignmentOne.Annotations.PutAPI;
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


    @Operation(summary = "Welcome Message and check controller!")
    @GetAPI("/welcome")
    public ResponseEntity<Response> wecomeMessage(){

        return ResponseEntity.status(HttpStatus.OK).body(
          new Response<>(
                  HttpStatus.OK,
                  true,
                  "Contact controller works fine!",
                    "Welcome To Contact Controller!"
          )
        );
    }

    @Operation(
            summary = "Add a Contact",
            description = "Single Contact creation API. Mandatory Fields: \"Email, Firstname, Birthdate, Job Title, Company, Gender\"\n" +
                    "\n ** Date Format:  dd-MM-yyyy **\n" +
                    "\n ** No address-id/contact-id should pass through through this api. It'll be auto generated!"
    )
    @PostAPI("/add-contact")
    public ResponseEntity<Response> addContact(@Valid @RequestBody Contact contact){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Response<>(
                        HttpStatus.CREATED,
                        true,
                        "Contact created Success!",
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
            @RequestParam(required = false) String endBirthDate,
            @RequestParam(required = false) String nidNo,
            @RequestParam(required = false) String passportNo,
            @RequestParam(required = false) String job,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String maxEducation,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String bloodGroup
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
        contactSearchCriteria.setNationalId(nidNo);
        contactSearchCriteria.setPassport(passportNo);
        contactSearchCriteria.setJobTitle(job);
        contactSearchCriteria.setCompany(company);
        contactSearchCriteria.setHighestEducation(maxEducation);
        contactSearchCriteria.setGender(gender);
        contactSearchCriteria.setBloodGroup(bloodGroup);


        return ResponseEntity.status(HttpStatus.OK).body(
                new Response<Object>(
                        HttpStatus.OK,
                        true,
                        "Successfully fetched all data!",
                        contactService.findContacts(contactSearchCriteria)
                )
        );
    }


    @Operation(
            summary = "Update Contact",
            description = "Single Contact **Update** API. Mandatory Fields: \"Id, Email, Firstname, Birthdate, Job Title, Company, Gender\"\n" +
                    "\n ** Date Format:  dd-MM-yyyy **"
    )
    @PutAPI("/update")
    public ResponseEntity<Response> updateContact(@Valid @RequestBody Contact contact){

        return ResponseEntity.status(HttpStatus.OK).body(
                new Response<>(
                        HttpStatus.OK,
                        true,
                        "Contact updated successfully!",
                        contactService.updateContact(contact)
                )
        );
    }

    @Operation(
            summary = "Delete Contact",
            description = "Simple pass a contact id to delete all data!"
    )
    @DeleteAPI("/delete")
    public ResponseEntity<Response> deleteContact(@RequestParam Long id){

        return ResponseEntity.status(HttpStatus.OK).body(
                new Response<>(
                        HttpStatus.OK,
                        true,
                        "Contact Deleted successfully!",
                        contactService.deleteContact(id)
                )
        );
    }

}
