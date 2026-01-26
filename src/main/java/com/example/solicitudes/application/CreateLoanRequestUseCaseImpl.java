package com.example.solicitudes.application;

import com.example.solicitudes.domain.model.LoanRequest;
import com.example.solicitudes.domain.model.State;
import com.example.solicitudes.domain.repository.LoanRequestRepository;
import com.example.solicitudes.domain.requests.CreateLoanRequestUseCase;
import com.example.solicitudes.domain.requests.CreateRequestQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateLoanRequestUseCaseImpl implements CreateLoanRequestUseCase {

    private final LoanRequestRepository loanRequestRepository;

    @Override
    public LoanRequest create(CreateRequestQuery query) {
        return loanRequestRepository.save(new LoanRequest(
                null,
                query.customerName(),
                query.amount(),
                query.badge(),
                query.dni(),
                State.PENDING,
                query.createdAt()
        ));
    }
}
