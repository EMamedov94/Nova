package com.example.nova.services.report;

import com.example.nova.models.Report;
import com.example.nova.models.ReportItem;
import com.example.nova.models.User;
import com.example.nova.models.dto.report.ReportRequestDto;
import com.example.nova.models.dto.report.ReportResponseDto;
import com.example.nova.repositories.ReportItemRepository;
import com.example.nova.repositories.ReportRepository;
import com.example.nova.repositories.UserRepository;
import com.example.nova.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportItemRepository reportItemRepository;
    private final UserService userService;

    @Override
    public ReportResponseDto createReport(ReportRequestDto reportRequestDto) {

        User currentUser = userService.getCurrentUser();

        ReportItem newReport = ReportItem.builder()
                .employee(currentUser)
                .depositsCount(reportRequestDto.getDepositsCount())
                .depositsAmount(reportRequestDto.getDepositsAmount())
                .cardsCount(reportRequestDto.getCardsCount())
                .insuranceCount(reportRequestDto.getInsuranceCount())
                .insuranceAmount(reportRequestDto.getInsuranceAmount())
                .build();

        return reportItemRepository.save(newReport);
    }
}
