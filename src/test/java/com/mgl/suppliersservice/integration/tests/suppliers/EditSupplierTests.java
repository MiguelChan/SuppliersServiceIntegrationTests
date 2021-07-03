package com.mgl.suppliersservice.integration.tests.suppliers;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.mgl.suppliersservice.integration.clients.dto.EditSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.EditSupplierResponse;
import com.mgl.suppliersservice.integration.clients.models.Contact;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import com.mgl.suppliersservice.integration.tests.BaseTests;
import com.mgl.suppliersservice.integration.utils.SuppliersUtils;
import io.github.benas.randombeans.api.EnhancedRandom;
import javax.inject.Inject;
import org.testng.annotations.Test;

@Test
public class EditSupplierTests extends BaseTests {

    @Inject
    private SuppliersUtils suppliersUtils;

    @Test
    public void editSupplier_should_editTheSupplier_when_noNewContactsAreAdded() throws Exception {
        String expectedName = "Miguel Chan";
        String expectedLineAddress1 = "Line Address 1";
        String expectedLineAddress2 = "Line Address 2";
        String expectedPhoneNumber = "123456";

        // 1.- Create the Supplier.
        Supplier supplier = suppliersUtils.createSupplier();

        // 2.- Let's edit the suppliers Attributes
        supplier.setName(expectedName);
        supplier.setLineAddress1(expectedLineAddress1);
        supplier.setLineAddress2(expectedLineAddress2);
        supplier.setPhoneNumber(expectedPhoneNumber);

        editSupplier(supplier.getId(), supplier);

        Supplier freshSupplier = suppliersUtils.getSupplier(supplier.getId());

        assertEquals(freshSupplier.getContacts().size(), supplier.getContacts().size());

        assertEquals(freshSupplier.getName(), expectedName);
        assertEquals(freshSupplier.getLineAddress1(), expectedLineAddress1);
        assertEquals(freshSupplier.getLineAddress2(), expectedLineAddress2);
        assertEquals(freshSupplier.getPhoneNumber(), expectedPhoneNumber);
    }

    @Test
    public void editSupplier_should_addNewContacts_when_newContactsAreProvided() throws Exception {
        String expectedName = "Miguel Chan";
        String expectedLineAddress1 = "Line Address 1";
        String expectedLineAddress2 = "Line Address 2";
        String expectedPhoneNumber = "123456";

        // 1.- Create the Supplier.
        Supplier supplier = suppliersUtils.createSupplier();

        int currentContactSize = supplier.getContacts().size();

        // 2.- Let's create a Random Contact
        Contact randomContact = EnhancedRandom.random(Contact.class, "id");
        supplier.getContacts().add(randomContact);

        // 2.- Let's edit the suppliers Attributes
        supplier.setName(expectedName);
        supplier.setLineAddress1(expectedLineAddress1);
        supplier.setLineAddress2(expectedLineAddress2);
        supplier.setPhoneNumber(expectedPhoneNumber);

        editSupplier(supplier.getId(), supplier);

        Supplier freshSupplier = suppliersUtils.getSupplier(supplier.getId());

        assertEquals(freshSupplier.getContacts().size(), currentContactSize + 1);

        assertEquals(freshSupplier.getName(), expectedName);
        assertEquals(freshSupplier.getLineAddress1(), expectedLineAddress1);
        assertEquals(freshSupplier.getLineAddress2(), expectedLineAddress2);
        assertEquals(freshSupplier.getPhoneNumber(), expectedPhoneNumber);

        boolean hasNewContact = freshSupplier.getContacts().stream().anyMatch(currentContact -> {
            return currentContact.getFirstName().equals(randomContact.getFirstName());
        });
        assertTrue(hasNewContact);
    }

    @Test
    public void editContact_should_returnUnsuccessfulResponse_when_supplierDoesNotExist() throws Exception {
        Supplier supplier = EnhancedRandom.random(Supplier.class);

        EditSupplierRequest request = EditSupplierRequest.builder()
            .supplier(supplier)
            .build();

        EditSupplierResponse response = this.suppliersServiceClient.editSupplier(supplier.getId(), request);

        assertFalse(response.isSuccess());
    }

    private void editSupplier(String supplierId, Supplier supplier) throws Exception {
        EditSupplierRequest request = EditSupplierRequest.builder()
            .supplier(supplier)
            .build();

        EditSupplierResponse response = this.suppliersServiceClient.editSupplier(supplierId, request);

        assertNotNull(response);
        assertTrue(response.isSuccess());
    }

}
