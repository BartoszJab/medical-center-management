package com.example.medicalcentermanagement.contactdetails;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ContactDetailsController {

    private final ContactDetailsService service;

    @PostMapping
    public ContactDetails createContactDetails(@RequestBody ContactDetails contactDetails) {
        return service.createContactDetails(contactDetails);
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
