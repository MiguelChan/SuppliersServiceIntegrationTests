package com.mgl.suppliersservice.integration.tests.contacts;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import com.mgl.suppliersservice.integration.clients.dto.EditContactRequest;
import com.mgl.suppliersservice.integration.clients.dto.EditContactResponse;
import com.mgl.suppliersservice.integration.clients.models.Contact;
import com.mgl.suppliersservice.integration.clients.models.ContactType;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import com.mgl.suppliersservice.integration.tests.BaseTests;
import com.mgl.suppliersservice.integration.utils.ContactsUtils;
import com.mgl.suppliersservice.integration.utils.SuppliersUtils;
import io.github.benas.randombeans.api.EnhancedRandom;
import javax.inject.Inject;
import org.testng.annotations.Test;

@Test
public class EditContactTests extends BaseTests {

    @Inject
    private SuppliersUtils suppliersUtils;
    @Inject
    private ContactsUtils contactsUtils;

    @Test
    public void editContact_should_editAContact() throws Exception {
        Supplier supplier = suppliersUtils.createSupplier();
        Contact contactToEdit = supplier.getContacts().get(0);

        contactToEdit.setContactType(ContactType.SALES_REP);
        contactToEdit.setFirstName("Miguel");
        contactToEdit.setLastName("Chan");
        contactToEdit.setEmailAddress("someSome@some.com");
        contactToEdit.setPhoneNumber("123456");

        String contactId = contactToEdit.getId();

        EditContactRequest request = EditContactRequest.builder()
            .contact(contactToEdit)
            .build();

        EditContactResponse response = this.suppliersServiceClient.editContact(contactId, request);

        assertNotNull(response);
        assertTrue(response.isSuccess());

        Contact updatedContact = contactsUtils.getContact(contactId);
        assertEquals(contactToEdit, updatedContact);
    }

    @Test
    public void editContact_should_returnUnsuccessfulResponse_when_contactDoesNotExist() throws Exception {
        String contactId = EnhancedRandom.random(String.class);
        Contact randomContact = EnhancedRandom.random(Contact.class);

        EditContactRequest request = EditContactRequest.builder()
            .contact(randomContact)
            .build();

        EditContactResponse response = this.suppliersServiceClient.editContact(contactId, request);

        assertNotNull(response);
        assertFalse(response.isSuccess());
    }

}
