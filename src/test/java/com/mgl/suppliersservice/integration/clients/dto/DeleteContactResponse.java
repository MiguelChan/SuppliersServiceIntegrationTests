package com.mgl.suppliersservice.integration.clients.dto;

import com.mgl.suppliersservice.integration.clients.models.Contact;
import lombok.Builder;
import lombok.Data;

/**
 *
 * Defines the Response for deleting a contact.
 *
 */
@Data
@Builder(toBuilder = true)
public class DeleteContactResponse {

    private Contact contact;
    private boolean deleted;

}
