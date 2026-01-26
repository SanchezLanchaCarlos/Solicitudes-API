package com.example.solicitudes.application;

import com.example.solicitudes.domain.model.LoanRequest;
import com.example.solicitudes.domain.repository.LoanRequestRepository;
import com.example.solicitudes.domain.requests.CreateRequestQuery;
import com.example.solicitudes.domain.requests.UpdateLoanRequestUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateLoanRequestUseCaseImpl implements UpdateLoanRequestUseCase {

    private final LoanRequestRepository loanRequestRepository;


    @Override
    public Optional<LoanRequest> updateRequest(Integer id, CreateRequestQuery query) {
        LoanRequest loanRequest = loanRequestRepository.findById(id).orElse(null);

        if (loanRequest == null)
            return Optional.empty();

        loanRequest.setState(query.state());

        return loanRequestRepository.update(loanRequest);
    }
}
