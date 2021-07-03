package com.mgl.suppliersservice.integration.clients.dto;

import com.mgl.suppliersservice.integration.clients.models.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * .
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class GetContactResponse {

    private Contact contact;

}
