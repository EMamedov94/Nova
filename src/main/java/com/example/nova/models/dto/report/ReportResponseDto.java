package com.example.nova.models.dto.report;

import com.example.nova.enums.ReportStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportResponseDto {

    private Long id;

    private String officeName;

    private String createdBy;

    private ReportStatus status;

    private LocalDateTime createdAt;

    private Integer depositsCount;
    private Integer depositsAmount;

    private Integer cardsCount;

    private Integer insuranceCount;
    private Integer insuranceAmount;
}
