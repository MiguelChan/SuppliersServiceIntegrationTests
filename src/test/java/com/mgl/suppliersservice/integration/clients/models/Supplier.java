package com.mgl.suppliersservice.integration.clients.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

/**
 * .
 */
@Data
@Setter
@Builder(toBuilder = true)
public class Supplier {

    private String id;
    private String name;
    private String phoneNumber;
    private String lineAddress1;
    private String lineAddress2;
    private List<Contact> contacts;

}
