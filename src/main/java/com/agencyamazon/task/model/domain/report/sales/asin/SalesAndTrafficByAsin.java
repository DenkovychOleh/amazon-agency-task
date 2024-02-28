package com.agencyamazon.task.model.domain.report.sales.asin;

import com.agencyamazon.task.model.domain.report.sales.asin.SalesByAsin;
import com.agencyamazon.task.model.domain.report.sales.asin.TrafficByAsin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesAndTrafficByAsin {

    private String parentAsin;

    private SalesByAsin salesByAsin;

    private TrafficByAsin trafficByAsin;

}
