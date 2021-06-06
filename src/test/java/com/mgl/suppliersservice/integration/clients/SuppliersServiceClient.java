package com.mgl.suppliersservice.integration.clients;

import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.DeleteSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSuppliersResponse;

/**
 * The Suppliers Service Client.
 *
 * This client defines the API endpoints that can be used by the SuppliersService.
 */
public interface SuppliersServiceClient {

    GetSuppliersResponse getSuppliers(int pageSize, int pageNumber) throws Exception;
    CreateSupplierResponse createSupplier(CreateSupplierRequest request) throws Exception;
    DeleteSupplierResponse deleteSupplier(String supplierId) throws Exception;
}
