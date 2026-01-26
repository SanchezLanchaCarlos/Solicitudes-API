package com.example.solicitudes.domain.requests;

import com.example.solicitudes.domain.model.State;

import java.time.LocalDate;

public record CreateRequestQuery(
        String customerName,
        Double amount,
        String badge,
        String dni,
        State state,
        LocalDate createdAt
    ) {
}
