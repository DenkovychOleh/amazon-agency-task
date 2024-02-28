package com.agencyamazon.task.service.internal.security.report;

import com.agencyamazon.task.model.domain.report.sales.asin.SalesAndTrafficByAsin;
import com.agencyamazon.task.model.domain.report.sales.date.SalesAndTrafficByDate;
import com.agencyamazon.task.repository.mongo.ReportMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceDefault implements ReportService {

    private final ReportMongoRepository reportMongoRepository;

    @Cacheable(value = "salesAndTrafficByAsin", key = "#asin")
    @Override
    public SalesAndTrafficByAsin findByAsin(String asin) {
        System.out.println("run findByAsin(String asin)");
        return reportMongoRepository.findSalesAndTrafficByAsin(asin);
    }

    @Cacheable(value = "salesAndTrafficByDate", key = "#date")
    @Override
    public SalesAndTrafficByDate findByDate(LocalDate date) {
        System.out.println("run findByDate(LocalDate date)");
        return reportMongoRepository.findSalesAndTrafficByDate(date);
    }

    @Override
    public List<SalesAndTrafficByDate> findAllByDateRange(LocalDate startDate, LocalDate endDate) {
        return reportMongoRepository.findSalesAndTrafficByDateBetween(startDate, endDate);
    }

    @Override
    public List<SalesAndTrafficByAsin> findSalesAndTrafficByAsinIn(List<String> asins) {
        return reportMongoRepository.findSalesAndTrafficByAsinIn(asins);
    }

    @Cacheable(value = "salesAndTrafficByDates")
    @Override
    public List<SalesAndTrafficByDate> findAllDate() {
        System.out.println("run findAllDate()");
        return reportMongoRepository.findAllSalesAndTrafficByDate();
    }

    @Cacheable(value = "salesAndTrafficByAsins")
    @Override
    public List<SalesAndTrafficByAsin> findAllAsin() {
        System.out.println("run findAllAsin()");
        return reportMongoRepository.findAllSalesAndTrafficByAsin();
    }

    @Scheduled(fixedRate = 300000)
    @CacheEvict(value = {"salesAndTrafficByAsin", "salesAndTrafficByDate",
            "salesAndTrafficByAsins", "salesAndTrafficByDates"}, allEntries = true)
    public void evictCache() {
    }

}
