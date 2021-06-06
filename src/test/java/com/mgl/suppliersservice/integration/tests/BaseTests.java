package com.mgl.suppliersservice.integration.tests;

import com.mgl.suppliersservice.integration.clients.SuppliersServiceClient;
import com.mgl.suppliersservice.integration.modules.ClientModule;
import javax.inject.Inject;
import org.testng.annotations.Guice;

@Guice(modules = ClientModule.class)
public class BaseTests {

    @Inject
    protected SuppliersServiceClient suppliersServiceClient;

}
