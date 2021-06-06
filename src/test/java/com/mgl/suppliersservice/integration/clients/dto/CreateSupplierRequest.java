package com.mgl.suppliersservice.integration.clients.dto;

import com.mgl.suppliersservice.integration.clients.models.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The DTO for requesting the Creation of a Supplier.
 */
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSupplierRequest {

    private Supplier supplier;

}
