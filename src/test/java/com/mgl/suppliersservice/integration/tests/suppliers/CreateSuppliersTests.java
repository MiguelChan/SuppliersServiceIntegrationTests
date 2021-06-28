package com.mgl.suppliersservice.integration.tests.suppliers;

import static org.testng.Assert.assertNotNull;

import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.models.Contact;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import com.mgl.suppliersservice.integration.tests.BaseTests;
import com.mgl.suppliersservice.integration.utils.TestConstants;
import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.List;
import org.testng.ITestContext;
import org.testng.annotations.Test;

@Test(groups = TestConstants.SUPPLIER_WORKFLOW_NAME)
public class CreateSuppliersTests extends BaseTests {

    @Test
    public void createSupplier_should_createASupplier(ITestContext testContext) throws Exception {
        Supplier randomSupplier = EnhancedRandom.random(Supplier.class, "contacts", "id");
        List<Contact> randomContacts = EnhancedRandom.randomListOf(2, Contact.class, "id");

        randomSupplier = randomSupplier.toBuilder().contacts(randomContacts).build();

        CreateSupplierRequest request = CreateSupplierRequest.builder()
            .supplier(randomSupplier)
            .build();

        CreateSupplierResponse response = this.suppliersServiceClient.createSupplier(request);

        assertNotNull(response);
        assertNotNull(response.getSupplierId());

        testContext.setAttribute(TestConstants.SHARED_SUPPLIER, randomSupplier);
        testContext.setAttribute(TestConstants.SHARED_SUPPLIER_ID, response.getSupplierId());
    }

}
