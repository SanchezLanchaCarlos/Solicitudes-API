package com.example.solicitudes.domain.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoanRequest {
    private Integer id;
    private String customerName;
    private Double amount;
    private String badge;
    private String dni;
    private State state;
    private LocalDate createdAt;
}
