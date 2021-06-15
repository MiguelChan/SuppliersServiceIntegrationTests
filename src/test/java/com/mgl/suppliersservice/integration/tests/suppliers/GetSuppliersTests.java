package com.mgl.suppliersservice.integration.tests.suppliers;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import com.mgl.suppliersservice.integration.clients.dto.GetSuppliersResponse;
import com.mgl.suppliersservice.integration.clients.models.Supplier;
import com.mgl.suppliersservice.integration.tests.BaseTests;
import com.mgl.suppliersservice.integration.utils.TestConstants;
import java.util.List;
import org.testng.annotations.Test;

@Test(dependsOnGroups = TestConstants.SUPPLIER_WORKFLOW_NAME)
public class GetSuppliersTests extends BaseTests {

    @Test
    public void getSuppliers_should_returnSuppliers() throws Exception {
        int pageSize = 100;
        int pageNumber = 0;

        GetSuppliersResponse suppliersResponse =
            this.suppliersServiceClient.getSuppliers(pageSize, pageNumber);

        assertNotNull(suppliersResponse);

        List<Supplier> suppliersList = suppliersResponse.getSuppliers();
        assertNotNull(suppliersList);
        assertFalse(suppliersList.isEmpty());
    }

}
