package com.example.medicalcentermanagement.contactdetails;

import com.example.medicalcentermanagement.exception.alreadyexists.ContactDetailsAlreadyExistsException;
import com.example.medicalcentermanagement.exception.notfound.ContactDetailsNotFoundException;
import com.example.medicalcentermanagement.exception.notfound.PatientNotFoundException;
import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.patient.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactDetailsService {

    private final ContactDetailsRepository contactDetailsRepository;
    private final PatientRepository patientRepository;

    public ContactDetailsResponse createContactDetails(ContactDetailsRequest contactDetailsRequest) {
        Long patientId = contactDetailsRequest.getPatientId();

        Patient patient =
                patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException(patientId));

        if (patient.getContactDetails() != null) {
            throw new ContactDetailsAlreadyExistsException(patient.getId());
        }

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setPhoneNumber(contactDetailsRequest.getPhoneNumber());
        contactDetails.setAddress(contactDetailsRequest.getAddress());
        contactDetails.setEmail(contactDetailsRequest.getEmail());
        contactDetails.setPatient(patient);
        patient.setContactDetails(contactDetails);
        contactDetailsRepository.save(contactDetails);

        return ContactDetailsResponse.toDto(contactDetails);
    }

    public ContactDetailsResponse updateContactDetails(Long id, ContactDetails newContactDetails) {
        return contactDetailsRepository.findById(id)
                .map(contactDetails -> {
                    contactDetails.setAddress(newContactDetails.getAddress());
                    contactDetails.setEmail(newContactDetails.getEmail());
                    contactDetails.setPhoneNumber(newContactDetails.getPhoneNumber());
                    contactDetailsRepository.save(contactDetails);

                    return ContactDetailsResponse.toDto(contactDetails);
                }).orElseThrow(() -> new ContactDetailsNotFoundException(id));
    }

    public void deleteContactDetails(Long id) {
        contactDetailsRepository.deleteById(id);
    }
}
