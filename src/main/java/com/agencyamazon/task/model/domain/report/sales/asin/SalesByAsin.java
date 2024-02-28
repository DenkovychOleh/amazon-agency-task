package com.agencyamazon.task.model.domain.report.sales.asin;

import com.agencyamazon.task.model.domain.report.sales.date.SalesAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesByAsin {

    private int unitsOrdered;

    private int unitsOrderedB2B;

    private SalesAmount orderedProductSales;

    private SalesAmount orderedProductSalesB2B;

    private int totalOrderItems;

    private int totalOrderItemsB2B;

}
