package com.example.solicitudes.domain.repository;

import com.example.solicitudes.domain.model.LoanRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoanRequestRepository {
    LoanRequest save(LoanRequest loanRequest);
    Optional<LoanRequest> findById(Integer id);
    List<LoanRequest> findAll();
    Optional<LoanRequest> update(LoanRequest loanRequest);

}
