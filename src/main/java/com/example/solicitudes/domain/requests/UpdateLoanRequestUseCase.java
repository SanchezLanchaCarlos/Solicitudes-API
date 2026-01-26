package com.example.solicitudes.domain.requests;

import com.example.solicitudes.domain.model.LoanRequest;

import java.util.Optional;
import java.util.UUID;

public interface UpdateLoanRequestUseCase {
    Optional<LoanRequest> updateRequest(Integer id, CreateRequestQuery query);
}
