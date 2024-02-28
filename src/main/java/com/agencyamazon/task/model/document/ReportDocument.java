package com.agencyamazon.task.model.document;

import com.agencyamazon.task.model.domain.report.sales.asin.SalesAndTrafficByAsin;
import com.agencyamazon.task.model.domain.report.sales.date.SalesAndTrafficByDate;
import com.agencyamazon.task.model.domain.report.specification.ReportSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reports")
public class ReportDocument {

    @Id
    private String id;

    private ReportSpecification reportSpecification;

    private List<SalesAndTrafficByDate> salesAndTrafficByDate = new ArrayList<>();

    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin = new ArrayList<>();

}
