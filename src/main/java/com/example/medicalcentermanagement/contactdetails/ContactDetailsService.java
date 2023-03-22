package com.example.medicalcentermanagement.contactdetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactDetailsService {

    private final ContactDetailsRepository contactDetailsRepository;

    public ContactDetails createContactDetails(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }

    public ContactDetails updateContactDetails(Long id, ContactDetails newContactDetails) {
        return contactDetailsRepository.findById(id)
                .map(contactDetails -> {
                    contactDetails.setAddress(newContactDetails.getAddress());
                    contactDetails.setEmail(newContactDetails.getEmail());
                    contactDetails.setPhoneNumber(newContactDetails.getPhoneNumber());

                    return contactDetailsRepository.save(contactDetails);
                }).orElseThrow();
    }

    public void deleteContactDetails(Long id) {
        contactDetailsRepository.deleteById(id);
    }
}
