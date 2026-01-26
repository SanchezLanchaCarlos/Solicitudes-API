package com.example.solicitudes.domain.requests;

import com.example.solicitudes.domain.model.LoanRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveLoanRequestUseCase {
    Optional<LoanRequest> getLRequestById(Integer id);
    List<LoanRequest> getAllRequests();
}
