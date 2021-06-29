package com.mgl.suppliersservice.integration.tests.contacts;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;

import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.DeleteContactResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSupplierResponse;
import com.mgl.suppliersservice.integration.clients.models.Contact;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import com.mgl.suppliersservice.integration.tests.BaseTests;
import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.List;
import org.testng.annotations.Test;

@Test
public class DeleteContactTests extends BaseTests {

    @Test
    public void deleteContact_should_deleteContact() throws Exception {
        Supplier supplier = createSupplier();

        Contact contactToDelete = supplier.getContacts().get(0);

        String contactId = contactToDelete.getId();

        DeleteContactResponse response = this.suppliersServiceClient.deleteContact(contactId);
        assertNotNull(response);
        assertNotNull(response.getContact());
        assertTrue(response.isDeleted());

        assertEquals(contactToDelete, response.getContact());

        GetSupplierResponse getSupplierResponse = this.suppliersServiceClient.getSupplier(supplier.getId());
        Supplier updatedSupplier = getSupplierResponse.getSupplier();

        assertTrue(updatedSupplier.getContacts().isEmpty());
    }

    @Test
    public void deleteContact_should_returnNothing_when_contactDoesNotExist() throws Exception {
        String randomContactId = EnhancedRandom.random(String.class);

        DeleteContactResponse response = this.suppliersServiceClient.deleteContact(randomContactId);

        assertFalse(response.isDeleted());
        assertNull(response.getContact());
    }

    private Supplier createSupplier() throws Exception {
        Supplier randomSupplier = EnhancedRandom.random(Supplier.class, "contacts", "id");
        List<Contact> randomContacts = EnhancedRandom.randomListOf(1, Contact.class, "id");

        randomSupplier.setContacts(randomContacts);

        CreateSupplierRequest request = CreateSupplierRequest.builder()
            .supplier(randomSupplier)
            .build();

        CreateSupplierResponse response = this.suppliersServiceClient.createSupplier(request);

        assertNotNull(response.getSupplierId());

        GetSupplierResponse getSupplierResponse = this.suppliersServiceClient.getSupplier(response.getSupplierId());
        assertNotNull(getSupplierResponse.getSupplier());

        return getSupplierResponse.getSupplier();
    }

}
