package com.example.nova.services.report;

import com.example.nova.models.dto.report.ReportRequestDto;
import com.example.nova.models.dto.report.ReportResponseDto;

public interface ReportService {

    ReportResponseDto createReport(ReportRequestDto reportRequestDto);

}
