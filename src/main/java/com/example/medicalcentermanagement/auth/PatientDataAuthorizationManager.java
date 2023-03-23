package com.example.medicalcentermanagement.auth;

import com.example.medicalcentermanagement.exception.PatientNotFoundException;
import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.patient.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class PatientDataAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    private final PatientRepository patientRepository;

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {

        if (hasRole(authentication, "ROLE_ADMIN") || hasRole(authentication, "ROLE_EMPLOYEE")) {
            return new AuthorizationDecision(true);
        }

        Long patientId = Long.parseLong(object.getVariables().get("patientId"));

        Patient patient =
                patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException(patientId));

        if (patient.getUser() == null) {
            return new AuthorizationDecision(false);
        }

        return new AuthorizationDecision(patient.getUser().getUsername().equals(authentication.get().getName()));
    }

    private boolean hasRole(Supplier<Authentication> authentication, String roleName) {

        for (GrantedAuthority a : authentication.get().getAuthorities()) {
            return a.getAuthority().equals(roleName);
        }

        return false;
    }
}