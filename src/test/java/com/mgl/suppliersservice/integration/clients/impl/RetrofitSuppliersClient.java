package com.mgl.suppliersservice.integration.clients.impl;

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
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    @DELETE("contacts/{contactId}")
    Call<DeleteContactResponse> deleteContact(@Path("contactId") String contactId);

    @PUT("contacts/{contactId}")
    Call<EditContactResponse> editContact(@Path("contactId") String contactId,
                                          @Body EditContactRequest editContactRequest);

    @GET("contacts/{contactId}")
    Call<GetContactResponse> getContact(@Path("contactId") String contactId);

    @GET("contacts")
    Call<GetContactsForSupplierResponse> getContactsForSupplier(@Query("supplierId") String supplierId);

}
