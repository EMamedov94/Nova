package com.example.nova.models;

import com.example.nova.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "reports")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report extends BaseEntity {

    @ManyToOne
    private Office office;

    @Enumerated(EnumType.STRING)
    private ReportStatus status;
}
