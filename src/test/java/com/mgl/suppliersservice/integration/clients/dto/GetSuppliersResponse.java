package com.mgl.suppliersservice.integration.clients.dto;

import com.mgl.suppliersservice.integration.clients.models.Supplier;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for Getting Suppliers.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class GetSuppliersResponse {

    private List<Supplier> suppliers;
    private int suppliersCount;

}
