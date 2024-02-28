package com.agencyamazon.task.model.domain.report.specification;

import com.agencyamazon.task.model.domain.report.specification.ReportOptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportSpecification {

    private String id;

    private String reportType;

    private ReportOptions reportOptions;

    private LocalDate dataStartTime;

    private LocalDate dataEndTime;

    private List<String> marketplaceIds = new ArrayList<>();

}
