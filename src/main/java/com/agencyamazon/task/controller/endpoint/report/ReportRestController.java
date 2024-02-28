package com.agencyamazon.task.controller.endpoint.report;

import com.agencyamazon.task.model.domain.report.sales.asin.SalesAndTrafficByAsin;
import com.agencyamazon.task.model.domain.report.sales.date.SalesAndTrafficByDate;
import com.agencyamazon.task.service.internal.security.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
@RestController
public class ReportRestController {

    private final ReportService reportService;

    @GetMapping("/asins/{parent-asin}")
    public SalesAndTrafficByAsin findByAsin(@PathVariable(name = "parent-asin") String asin) {
        return reportService.findByAsin(asin);
    }

    @GetMapping("/asins")
    public List<SalesAndTrafficByAsin> findAllByAsinIn(@RequestParam("asins") List<String> asins) {
        return reportService.findSalesAndTrafficByAsinIn(asins);
    }

    @GetMapping("/asins/all")
    public List<SalesAndTrafficByAsin> findAllAsin() {
        return reportService.findAllAsin();
    }

    @GetMapping("/dates/all")
    public List<SalesAndTrafficByDate> findAllDate() {
        return reportService.findAllDate();
    }

    @GetMapping("/dates/{date}")
    public SalesAndTrafficByDate findByDate(
            @PathVariable(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        return reportService.findByDate(date);
    }

    @GetMapping("/dates")
    public List<SalesAndTrafficByDate> findAllByDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return reportService.findAllByDateRange(startDate, endDate);
    }

}
