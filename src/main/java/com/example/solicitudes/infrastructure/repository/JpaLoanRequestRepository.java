package com.example.solicitudes.infrastructure.repository;

import com.example.solicitudes.infrastructure.entity.LoanRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaLoanRequestRepository extends JpaRepository<LoanRequestEntity, Long> {
    Optional<LoanRequestEntity> findById(Integer id);
}
