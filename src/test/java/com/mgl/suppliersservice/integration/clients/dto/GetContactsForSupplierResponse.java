package com.mgl.suppliersservice.integration.clients.dto;

import com.mgl.suppliersservice.integration.clients.models.Contact;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response for requesting Contacts.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class GetContactsForSupplierResponse {

    private List<Contact> contacts;

}
