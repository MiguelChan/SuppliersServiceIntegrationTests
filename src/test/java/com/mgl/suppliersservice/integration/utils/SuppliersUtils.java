package com.mgl.suppliersservice.integration.utils;

import static org.testng.AssertJUnit.assertNotNull;

import com.mgl.suppliersservice.integration.clients.SuppliersServiceClient;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSupplierResponse;
import com.mgl.suppliersservice.integration.clients.models.Contact;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.List;
import javax.inject.Inject;

/**
 * Utils for {@link Supplier}.
 */
public class SuppliersUtils {

    private final SuppliersServiceClient serviceClient;

    @Inject
    public SuppliersUtils(SuppliersServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Creates a Supplier and makes assertions on top of this.
     *
     * @return .
     */
    public Supplier createSupplier() throws Exception {
        Supplier supplierToCreate = EnhancedRandom.random(Supplier.class, "id", "contacts");
        List<Contact> contacts = EnhancedRandom.randomListOf(2, Contact.class, "id");

        supplierToCreate.setContacts(contacts);

        CreateSupplierRequest request = CreateSupplierRequest.builder()
            .supplier(supplierToCreate)
            .build();

        CreateSupplierResponse response = serviceClient.createSupplier(request);
        assertNotNull(response);
        assertNotNull(response.getSupplierId());

        return getSupplier(response.getSupplierId());
    }

    /**
     * Gets a Supplier by its Id.
     * @param supplierId .
     * @return .
     * @throws Exception .
     */
    public Supplier getSupplier(String supplierId) throws Exception {
        GetSupplierResponse getSupplierResponse = serviceClient.getSupplier(supplierId);
        assertNotNull(getSupplierResponse);
        assertNotNull(getSupplierResponse.getSupplier());
        return getSupplierResponse.getSupplier();
    }

}
