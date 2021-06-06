package com.mgl.suppliersservice.integration.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mgl.suppliersservice.integration.clients.SuppliersServiceClient;
import com.mgl.suppliersservice.integration.clients.impl.RetrofitSuppliersClient;
import com.mgl.suppliersservice.integration.clients.impl.RetrofitSuppliersServiceClient;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientModule extends AbstractModule {

    private static final String SUPPLIERS_BASE_URL = "http://localhost:8090/api/";

    @Override
    protected void configure() {
        bind(SuppliersServiceClient.class).to(RetrofitSuppliersServiceClient.class);
    }

    @Provides
    @Singleton
    public RetrofitSuppliersClient retrofitSuppliersClient() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SUPPLIERS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit.create(RetrofitSuppliersClient.class);
    }

}
