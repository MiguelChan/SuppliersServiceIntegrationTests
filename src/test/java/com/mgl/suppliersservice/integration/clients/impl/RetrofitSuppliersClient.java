package com.mgl.suppliersservice.integration.clients.impl;

import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierRequest;
import com.mgl.suppliersservice.integration.clients.dto.CreateSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.DeleteSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSupplierResponse;
import com.mgl.suppliersservice.integration.clients.dto.GetSuppliersResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitSuppliersClient {

    @GET("suppliers")
    Call<GetSuppliersResponse> getSuppliers(
        @Query("pageNumber") int pageNumber,
        @Query("pageSize") int pageSize
    );

    @POST("suppliers")
    Call<CreateSupplierResponse> createSupplier(@Body CreateSupplierRequest request);

    @DELETE("suppliers/{supplierId}")
    Call<DeleteSupplierResponse> deleteSupplier(@Path("supplierId") String supplierId);

    @GET("suppliers/{supplierId}")
    Call<GetSupplierResponse> getSupplier(@Path("supplierId") String supplierId);

}
