package com.mgl.suppliersservice.integration.tests.suppliers;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;

import com.mgl.suppliersservice.integration.clients.dto.DeleteSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSupplierResponse;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import com.mgl.suppliersservice.integration.tests.BaseTests;
import com.mgl.suppliersservice.integration.utils.SuppliersUtils;
import io.github.benas.randombeans.api.EnhancedRandom;
import javax.inject.Inject;
import org.testng.annotations.Test;

@Test
public class DeleteSupplierTests extends BaseTests {

    @Inject
    private SuppliersUtils suppliersUtils;

    @Test
    public void deleteSupplier_should_deleteTheSupplier() throws Exception {
        Supplier newSupplier = suppliersUtils.createSupplier();

        String supplierId = newSupplier.getId();

        DeleteSupplierResponse deleteSupplierResponse = suppliersServiceClient.deleteSupplier(supplierId);
        assertNotNull(deleteSupplierResponse);
        assertTrue(deleteSupplierResponse.isDeleted());
        assertEquals(newSupplier, deleteSupplierResponse.getSupplier());

        GetSupplierResponse getSupplierResponse = suppliersServiceClient.getSupplier(supplierId);
        assertNull(getSupplierResponse.getSupplier());
    }

    @Test
    public void deleteSupplier_should_returnEmptyResponse_when_supplierIdDoesNotExist() throws Exception {
        String randomId = EnhancedRandom.random(String.class);

        DeleteSupplierResponse response = suppliersServiceClient.deleteSupplier(randomId);

        assertNotNull(response);
        assertFalse(response.isDeleted());
        assertNull(response.getSupplier());
    }

}
