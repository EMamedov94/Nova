package com.example.nova.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "reportItems")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportItem extends BaseEntity {

    @ManyToOne
    private Report report;

    @ManyToOne
    private User employee;

    private Integer depositsCount;
    private Integer depositsAmount;

    private Integer cardsCount;

    private Integer insuranceCount;
    private Integer insuranceAmount;
}
