package com.example.nova.repositories;

import com.example.nova.models.ReportItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportItemRepository extends JpaRepository<ReportItem, Long> {
}
