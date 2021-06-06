package com.mgl.suppliersservice.integration.clients.impl;

import com.mgl.suppliersservice.integration.clients.SuppliersServiceClient;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.DeleteSupplierResponse;
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
}
