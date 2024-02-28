package com.agencyamazon.task.model.domain.report.sales.date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesByDate {

    private SalesAmount orderedProductSales;

    private SalesAmount orderedProductSalesB2B;

    private int unitsOrdered;

    private int unitsOrderedB2B;

    private int totalOrderItems;

    private int totalOrderItemsB2B;

    private SalesAmount averageSalesPerOrderItem;

    private SalesAmount averageSalesPerOrderItemB2B;

    private double averageUnitsPerOrderItem;

    private double averageUnitsPerOrderItemB2B;

    private SalesAmount averageSellingPrice;

    private SalesAmount averageSellingPriceB2B;

    private int unitsRefunded;

    private double refundRate;

    private int claimsGranted;

    private SalesAmount claimsAmount;

    private SalesAmount shippedProductSales;

    private int unitsShipped;

    private int ordersShipped;

}
