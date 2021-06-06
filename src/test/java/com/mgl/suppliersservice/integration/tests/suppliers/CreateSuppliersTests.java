package com.mgl.suppliersservice.integration.tests.suppliers;

import static org.testng.Assert.assertNotNull;

import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import com.mgl.suppliersservice.integration.tests.BaseTests;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.testng.annotations.Test;

@Test
public class CreateSuppliersTests extends BaseTests {

    @Test
    public void createSupplier_should_createASupplier() throws Exception {
        Supplier randomSupplier = EnhancedRandom.random(Supplier.class);

        CreateSupplierRequest request = CreateSupplierRequest.builder()
            .supplier(randomSupplier)
            .build();

        CreateSupplierResponse response = this.suppliersServiceClient.createSupplier(request);

        assertNotNull(response);
        assertNotNull(response.getSupplierId());
    }

}
