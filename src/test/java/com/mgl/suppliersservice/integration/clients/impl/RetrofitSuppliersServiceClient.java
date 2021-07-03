package com.mgl.suppliersservice.integration.clients.impl;

import com.mgl.suppliersservice.integration.clients.SuppliersServiceClient;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.DeleteContactResponse;
import com.mgl.suppliersservice.integration.clients.dto.DeleteSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.EditContactRequest;
import com.mgl.suppliersservice.integration.clients.dto.EditContactResponse;
import com.mgl.suppliersservice.integration.clients.dto.EditSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.EditSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetContactResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetContactsForSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSuppliersResponse;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Call;
import retrofit2.Response;

@Singleton
public class RetrofitSuppliersServiceClient  implements SuppliersServiceClient {

    private final RetrofitSuppliersClient retrofitClient;

    @Inject
    public RetrofitSuppliersServiceClient(RetrofitSuppliersClient retrofitClient) {
        this.retrofitClient = retrofitClient;
    }

    @Override
    public GetSuppliersResponse getSuppliers(int pageSize, int pageNumber) throws Exception{
        Call<GetSuppliersResponse> call = retrofitClient.getSuppliers(pageNumber, pageSize);
        Response<GetSuppliersResponse> callResponse = call.execute();
        return callResponse.body();
    }

    @Override
    public CreateSupplierResponse createSupplier(CreateSupplierRequest request) throws Exception {
        Call<CreateSupplierResponse> call = retrofitClient.createSupplier(request);
        Response<CreateSupplierResponse> callResponse = call.execute();
        return callResponse.body();
    }

    @Override
    public DeleteSupplierResponse deleteSupplier(String supplierId) throws Exception {
        Call<DeleteSupplierResponse> call = retrofitClient.deleteSupplier(supplierId);
        return call.execute().body();
    }

    @Override
    public GetSupplierResponse getSupplier(String supplierId) throws Exception {
        Call<GetSupplierResponse> call = retrofitClient.getSupplier(supplierId);
        Response<GetSupplierResponse> getResponse = call.execute();
        return getResponse.body();
    }

    @Override
    public DeleteContactResponse deleteContact(String contactId) throws Exception {
        Call<DeleteContactResponse> call = retrofitClient.deleteContact(contactId);
        Response<DeleteContactResponse> deleteResponse = call.execute();
        return deleteResponse.body();
    }

    @Override
    public EditContactResponse editContact(String contactId, EditContactRequest request) throws Exception {
        Call<EditContactResponse> call = retrofitClient.editContact(contactId, request);
        Response<EditContactResponse> editResponse = call.execute();
        return editResponse.body();
    }

    @Override
    public GetContactsForSupplierResponse getContactsForSupplier(String supplierId) throws Exception {
        Call<GetContactsForSupplierResponse> call = retrofitClient.getContactsForSupplier(supplierId);
        Response<GetContactsForSupplierResponse> getResponse = call.execute();
        return getResponse.body();
    }

    @Override
    public GetContactResponse getContact(String contactId) throws Exception {
        Call<GetContactResponse> call = retrofitClient.getContact(contactId);
        Response<GetContactResponse> getResponse = call.execute();
        return getResponse.body();
    }

    @Override
    public EditSupplierResponse editSupplier(String supplierId, EditSupplierRequest request)
        throws Exception {
        Call<EditSupplierResponse> call = retrofitClient.editSupplier(supplierId, request);
        Response<EditSupplierResponse> putResponse = call.execute();
        return putResponse.body();
    }
}
