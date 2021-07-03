package com.mgl.suppliersservice.integration.clients.dto;

import com.mgl.suppliersservice.integration.clients.models.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A request for edit a Contact.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class EditContactRequest {

    private Contact contact;

}
