package com.example.solicitudes.domain.requests;

import com.example.solicitudes.domain.model.LoanRequest;

public interface CreateLoanRequestUseCase {
    LoanRequest create(CreateRequestQuery query);
}
