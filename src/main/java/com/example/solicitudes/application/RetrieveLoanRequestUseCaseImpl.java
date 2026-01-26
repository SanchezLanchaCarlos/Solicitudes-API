package com.example.solicitudes.application;

import com.example.solicitudes.domain.model.LoanRequest;
import com.example.solicitudes.domain.repository.LoanRequestRepository;
import com.example.solicitudes.domain.requests.RetrieveLoanRequestUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RetrieveLoanRequestUseCaseImpl implements RetrieveLoanRequestUseCase {

    private final LoanRequestRepository loanRequestRepository;

    @Override
    public Optional<LoanRequest> getLRequestById(Integer id) {
        return loanRequestRepository.findById(id);
    }

    @Override
    public List<LoanRequest> getAllRequests() {
        return loanRequestRepository.findAll();
    }
}
