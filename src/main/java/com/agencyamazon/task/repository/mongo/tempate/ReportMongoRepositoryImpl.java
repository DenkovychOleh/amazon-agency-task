package com.agencyamazon.task.repository.mongo.tempate;

import com.agencyamazon.task.model.document.ReportDocument;
import com.agencyamazon.task.model.domain.report.sales.asin.SalesAndTrafficByAsin;
import com.agencyamazon.task.model.domain.report.sales.date.SalesAndTrafficByDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReportMongoRepositoryImpl implements ReportMongoTemplateRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public SalesAndTrafficByAsin findSalesAndTrafficByAsin(String asin) {
        Query query = new Query();
        query.addCriteria(Criteria.where("salesAndTrafficByAsin.parentAsin").is(asin));

        ReportDocument reportDocument = mongoTemplate.findOne(query, ReportDocument.class);
        if (reportDocument != null && reportDocument.getSalesAndTrafficByAsin() != null) {
            return reportDocument.getSalesAndTrafficByAsin().stream()
                    .filter(salesAndTrafficByAsin ->
                            salesAndTrafficByAsin.getParentAsin().equals(asin))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    @Override
    public SalesAndTrafficByDate findSalesAndTrafficByDate(LocalDate date) {
        String dateString = date.format(DateTimeFormatter.ISO_DATE);

        Query query = new Query();
        query.addCriteria(Criteria.where("salesAndTrafficByDate.date").is(dateString));

        ReportDocument reportDocument = mongoTemplate.findOne(query, ReportDocument.class);
        if (reportDocument != null && reportDocument.getSalesAndTrafficByDate() != null) {
            return reportDocument.getSalesAndTrafficByDate().stream()
                    .filter(salesAndTrafficByDate ->
                            salesAndTrafficByDate.getDate().equals(date))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    @Override
    public List<SalesAndTrafficByDate> findSalesAndTrafficByDateBetween(LocalDate startDate, LocalDate endDate) {
        String startDateString = startDate.format(DateTimeFormatter.ISO_DATE);
        String endDateString = endDate.format(DateTimeFormatter.ISO_DATE);

        Query query = new Query();
        query.addCriteria(Criteria.where("salesAndTrafficByDate.date").gte(startDateString).lte(endDateString));

        List<SalesAndTrafficByDate> result = new ArrayList<>();
        ReportDocument reportDocument = mongoTemplate.findOne(query, ReportDocument.class);
        if (reportDocument != null && reportDocument.getSalesAndTrafficByDate() != null) {
            result = reportDocument.getSalesAndTrafficByDate().stream()
                    .filter(salesAndTrafficByDate ->
                            salesAndTrafficByDate.getDate().isAfter(startDate.minusDays(1)) &&
                                    salesAndTrafficByDate.getDate().isBefore(endDate.plusDays(1)))
                    .toList();
        }
        return result;
    }

    @Override
    public List<SalesAndTrafficByAsin> findSalesAndTrafficByAsinIn(List<String> asinList) {
        Query query = new Query();
        query.addCriteria(Criteria.where("salesAndTrafficByAsin.parentAsin").in(asinList));

        List<SalesAndTrafficByAsin> result = new ArrayList<>();
        ReportDocument reportDocuments = mongoTemplate.findOne(query, ReportDocument.class);
        if (reportDocuments != null && reportDocuments.getSalesAndTrafficByAsin() != null) {
            result = reportDocuments.getSalesAndTrafficByAsin().stream()
                    .filter(salesAndTrafficByAsin ->
                            asinList.contains(salesAndTrafficByAsin.getParentAsin()))
                    .toList();
        }
        return result;
    }

    @Override
    public List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin() {
        ReportDocument reportDocuments = mongoTemplate.findAll(ReportDocument.class).getFirst();
        return reportDocuments.getSalesAndTrafficByAsin();
    }

    @Override
    public List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate() {
        ReportDocument reportDocuments = mongoTemplate.findAll(ReportDocument.class).getFirst();
        return reportDocuments.getSalesAndTrafficByDate();
    }

}