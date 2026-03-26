package com.example.nova.models.dto.report;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportRequestDto {

    private Integer depositsCount;
    private Integer depositsAmount;

    private Integer cardsCount;

    private Integer insuranceCount;
    private Integer insuranceAmount;
}
