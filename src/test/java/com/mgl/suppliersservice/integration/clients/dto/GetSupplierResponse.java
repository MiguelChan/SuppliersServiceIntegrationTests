package com.mgl.suppliersservice.integration.clients.dto;

import com.mgl.suppliersservice.integration.clients.models.Supplier;
import lombok.Builder;
import lombok.Data;

/**
 * The DTO for fetching a single supplier.
 */
@Builder(toBuilder = true)
@Data
public class GetSupplierResponse {

    private final Supplier supplier;

}
