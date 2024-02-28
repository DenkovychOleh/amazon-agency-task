package com.agencyamazon.task.model.domain.report.sales.date;

import com.agencyamazon.task.model.domain.report.sales.date.SalesByDate;
import com.agencyamazon.task.model.domain.report.sales.date.TrafficByDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesAndTrafficByDate {

    private LocalDate date;

    private SalesByDate salesByDate;

    private TrafficByDate trafficByDate;

}
