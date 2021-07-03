package com.mgl.suppliersservice.integration.clients;

import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.DeleteContactResponse;
import com.mgl.suppliersservice.integration.clients.dto.DeleteSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.EditContactRequest;
import com.mgl.suppliersservice.integration.clients.dto.EditContactResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetContactResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetContactsForSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSupplierResponse;
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
    GetSupplierResponse getSupplier(String supplierId) throws Exception;
    DeleteContactResponse deleteContact(String contactId) throws Exception;
    EditContactResponse editContact(String contactId, EditContactRequest request) throws Exception;
    GetContactsForSupplierResponse getContactsForSupplier(String supplierId) throws Exception;
    GetContactResponse getContact(String contactId) throws Exception;

}
