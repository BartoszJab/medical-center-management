package com.example.medicalcentermanagement.contactdetails;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactDetailsController {

    private final ContactDetailsService service;

    @PostMapping
    public ResponseEntity<ContactDetails> createContactDetails(@RequestBody ContactDetailsRequest request) {
        return new ResponseEntity<>(service.createContactDetails(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ContactDetails updateContactDetails(@PathVariable Long id, @RequestBody ContactDetails newPatient) {
        return service.updateContactDetails(id, newPatient);
    }

    @DeleteMapping("/{id}")
    public void deleteContactDetails(@PathVariable Long id) {
        service.deleteContactDetails(id);
    }
}
