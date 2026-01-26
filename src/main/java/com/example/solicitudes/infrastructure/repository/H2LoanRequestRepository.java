package com.example.solicitudes.infrastructure.repository;

import com.example.solicitudes.domain.model.LoanRequest;
import com.example.solicitudes.domain.repository.LoanRequestRepository;
import com.example.solicitudes.infrastructure.entity.LoanRequestEntity;
import com.example.solicitudes.infrastructure.mapper.LoanRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class H2LoanRequestRepository implements LoanRequestRepository {

    private final JpaLoanRequestRepository jpaLoanRequestRepository;
    private final LoanRequestMapper loanRequestMapper;

    @Override
    public LoanRequest save(LoanRequest loanRequest) {
        LoanRequestEntity loanRequestEntity = loanRequestMapper.toEntity(loanRequest);
        return loanRequestMapper.toDomain(jpaLoanRequestRepository.save(loanRequestEntity));
    }

    @Override
    public Optional<LoanRequest> findById(Integer id) {
        return jpaLoanRequestRepository.findById(id)
                .map(loanRequestMapper::toDomain);
    }

    @Override
    public List<LoanRequest> findAll() {
        return jpaLoanRequestRepository.findAll()
                .stream()
                .map(loanRequestMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<LoanRequest> update(LoanRequest loanRequest) {
        return Optional.of(jpaLoanRequestRepository.save(loanRequestMapper.toEntity(loanRequest)))
                .map(loanRequestMapper::toDomain);
    }
}
