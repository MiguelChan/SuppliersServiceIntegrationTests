package com.mgl.suppliersservice.integration.clients.models;

import lombok.Builder;
import lombok.Data;

/**
 * Defines a Contact.
 */
@Data
@Builder(toBuilder = true)
public class Contact {

    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private ContactType contactType;

}
