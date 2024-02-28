package com.agencyamazon.task.repository.mongo.tempate;

import com.agencyamazon.task.model.domain.report.sales.asin.SalesAndTrafficByAsin;
import com.agencyamazon.task.model.domain.report.sales.date.SalesAndTrafficByDate;

import java.time.LocalDate;
import java.util.List;

public interface ReportMongoTemplateRepository {

    SalesAndTrafficByAsin findSalesAndTrafficByAsin(String asin);

    SalesAndTrafficByDate findSalesAndTrafficByDate(LocalDate date);

    List<SalesAndTrafficByDate> findSalesAndTrafficByDateBetween(LocalDate startDate, LocalDate endDate);

    List<SalesAndTrafficByAsin> findSalesAndTrafficByAsinIn(List<String> asinList);

    List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin();

    List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate();

}
