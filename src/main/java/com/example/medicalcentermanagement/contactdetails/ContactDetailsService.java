package com.example.medicalcentermanagement.contactdetails;

import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.patient.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactDetailsService {

    private final ContactDetailsRepository contactDetailsRepository;
    private final PatientRepository patientRepository;

    public ContactDetails createContactDetails(ContactDetailsRequest contactDetailsRequest) {
        Patient patient = patientRepository.findById(contactDetailsRequest.getPatientId()).orElseThrow();

        if (patient.getContactDetails() != null) {
            throw new IllegalStateException("Contact details already exist for patient " + patient.getId());
        }

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setPhoneNumber(contactDetailsRequest.getPhoneNumber());
        contactDetails.setAddress(contactDetailsRequest.getAddress());
        contactDetails.setEmail(contactDetailsRequest.getEmail());
        contactDetails.setPatient(patient);
        patient.setContactDetails(contactDetails);

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
