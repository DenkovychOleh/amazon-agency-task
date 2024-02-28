package com.agencyamazon.task.repository.mongo;

import com.agencyamazon.task.model.document.ReportDocument;
import com.agencyamazon.task.model.domain.report.sales.asin.SalesAndTrafficByAsin;
import com.agencyamazon.task.model.domain.report.sales.date.SalesAndTrafficByDate;
import com.agencyamazon.task.repository.mongo.tempate.ReportMongoTemplateRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportMongoRepository extends MongoRepository<ReportDocument, String>, ReportMongoTemplateRepository {

    SalesAndTrafficByAsin findSalesAndTrafficByAsin(String asin);

    SalesAndTrafficByDate findSalesAndTrafficByDate(LocalDate date);

    List<SalesAndTrafficByDate> findSalesAndTrafficByDateBetween(LocalDate startDate, LocalDate endDate);

    List<SalesAndTrafficByAsin> findSalesAndTrafficByAsinIn(List<String> asinList);

    List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin();

    List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate();

}