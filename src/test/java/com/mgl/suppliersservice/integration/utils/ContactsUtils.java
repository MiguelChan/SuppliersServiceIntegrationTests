package com.mgl.suppliersservice.integration.utils;

import static org.testng.AssertJUnit.assertNotNull;

import com.mgl.suppliersservice.integration.clients.SuppliersServiceClient;
import com.mgl.suppliersservice.integration.clients.dto.GetContactResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetContactsForSupplierResponse;
import com.mgl.suppliersservice.integration.clients.models.Contact;
import java.util.List;
import javax.inject.Inject;

public class ContactsUtils {

    private final SuppliersServiceClient suppliersServiceClient;

    @Inject
    public ContactsUtils(SuppliersServiceClient suppliersServiceClient) {
        this.suppliersServiceClient = suppliersServiceClient;
    }

    public List<Contact> getContactsForSupplier(String supplierId) throws Exception {
        GetContactsForSupplierResponse response = suppliersServiceClient.getContactsForSupplier(supplierId);
        assertNotNull(response);
        return response.getContacts();
    }

    public Contact getContact(String contactId) throws Exception {
        GetContactResponse response = suppliersServiceClient.getContact(contactId);
        assertNotNull(response);
        return response.getContact();
    }

}
