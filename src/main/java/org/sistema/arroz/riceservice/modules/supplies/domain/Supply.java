package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

@Data
@Builder
@AllArgsConstructor
public class Supply {
    Long supplyId;
    String supplyName;
    Integer stock;
    Double unitPricing;
    Integer stockMin;
    SupplyMetricType supplyMetricType;
    Boolean state;
    AgricultureCommunity community;
}