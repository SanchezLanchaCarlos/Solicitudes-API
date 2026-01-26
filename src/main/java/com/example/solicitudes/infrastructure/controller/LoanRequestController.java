package com.example.solicitudes.infrastructure.controller;

import com.example.solicitudes.domain.model.LoanRequest;
import com.example.solicitudes.domain.requests.CreateLoanRequestUseCase;
import com.example.solicitudes.domain.requests.RetrieveLoanRequestUseCase;
import com.example.solicitudes.domain.requests.UpdateLoanRequestUseCase;
import com.example.solicitudes.infrastructure.mapper.LoanDataMapper;
import com.example.solicitudes.infrastructure.mapper.LoanRequestMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.SolicitudesApi;
import org.openapitools.model.CreateLoanData;
import org.openapitools.model.LoanResponse;
import org.openapitools.model.UpdateLoanData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoanRequestController implements SolicitudesApi {

    private final CreateLoanRequestUseCase createLoanRequestUseCase;
    private final RetrieveLoanRequestUseCase  retrieveLoanRequestUseCase;
    private final UpdateLoanRequestUseCase updateLoanRequestUseCase;
    private final LoanDataMapper loanDataMapper;
    private final LoanRequestMapper loanRequestMapper;

    @Override
    public ResponseEntity<LoanResponse> createRequest(CreateLoanData loanData) {
        LoanRequest loanRequest = createLoanRequestUseCase.create(loanDataMapper.toCreateRequestQuery(loanData));
        return ResponseEntity.ok(loanRequestMapper.toResponse(loanRequest));
    }

    @Override
    public ResponseEntity<List<LoanResponse>> getAllRequests() {
        List<LoanResponse> response = retrieveLoanRequestUseCase.getAllRequests()
                .stream()
                .map(loanRequestMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<LoanResponse> getRequestById(Integer id) {
        Optional<LoanResponse> response = retrieveLoanRequestUseCase.getLRequestById(id)
                .map(loanRequestMapper::toResponse);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<LoanResponse> updateRequest(Integer id, UpdateLoanData loanData) {
        Optional<LoanResponse> response = updateLoanRequestUseCase.updateRequest(id, loanDataMapper.toUpdateRequestQuery(loanData))
                .map(loanRequestMapper::toResponse);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
