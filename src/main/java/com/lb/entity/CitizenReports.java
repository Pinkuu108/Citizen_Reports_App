package com.lb.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "citizen_reports")
public class CitizenReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer citizenId;

    private String citizenName;

    private String planName;

    private String gender;

    private String citizenStatus;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double benefitAmount;

    private String deniedReason;

    private LocalDate terminatedDate;

    private String terminatedReason;
}
