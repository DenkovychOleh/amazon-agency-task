package com.agencyamazon.task.service.internal.security.report;

import com.agencyamazon.task.model.domain.report.sales.asin.SalesAndTrafficByAsin;
import com.agencyamazon.task.model.domain.report.sales.date.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {

    SalesAndTrafficByAsin findByAsin(String asin);

    SalesAndTrafficByDate findByDate(LocalDate date);

    List<SalesAndTrafficByDate> findAllByDateRange(LocalDate startDate, LocalDate endDate);

    List<SalesAndTrafficByAsin> findSalesAndTrafficByAsinIn(List<String> asins);

    List<SalesAndTrafficByDate> findAllDate();

    List<SalesAndTrafficByAsin> findAllAsin();

}
