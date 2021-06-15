package com.mgl.suppliersservice.integration.tests.suppliers;

import static org.testng.Assert.assertNotNull;

import com.mgl.suppliersservice.integration.clients.dto.GetSupplierResponse;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import com.mgl.suppliersservice.integration.tests.BaseTests;
import com.mgl.suppliersservice.integration.utils.TestConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

@Test(dependsOnGroups = TestConstants.SUPPLIER_WORKFLOW_NAME)
public class GetSupplierTests extends BaseTests {

    @Test
    public void getSupplier_should_returnSupplier(ITestContext testContext) throws Exception {
        String supplierId = (String) testContext.getAttribute(TestConstants.SHARED_SUPPLIER_ID);

        GetSupplierResponse response = this.suppliersServiceClient.getSupplier(supplierId);

        assertNotNull(response);

        Supplier supplier = response.getSupplier();
        assertNotNull(supplier, "Expected SupplierId: " + supplierId + " to exist");
    }

}
