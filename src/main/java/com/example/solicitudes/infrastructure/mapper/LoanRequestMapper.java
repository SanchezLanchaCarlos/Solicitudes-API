package com.example.solicitudes.infrastructure.mapper;

import com.example.solicitudes.domain.model.LoanRequest;
import com.example.solicitudes.infrastructure.entity.LoanRequestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.LoanResponse;

@Mapper(componentModel = "spring", uses = { DateMapper.class })
public interface LoanRequestMapper {

    @Mapping(source = "id", target= "id")
    @Mapping(source = "customerName", target= "customerName")
    @Mapping(source = "amount", target= "amount")
    @Mapping(source = "badge", target= "badge")
    @Mapping(source = "dni", target= "dni")
    @Mapping(source = "state", target= "state")
    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "toLocalDate")
    LoanRequest toDomain(final LoanRequestEntity loanRequestEntity);

    @Mapping(source = "id", target= "id")
    @Mapping(source = "customerName", target= "customerName")
    @Mapping(source = "amount", target= "amount")
    @Mapping(source = "badge", target= "badge")
    @Mapping(source = "dni", target= "dni")
    @Mapping(source = "state", target= "state")
    @Mapping(source = "createdAt", target = "createdAt")
    LoanRequestEntity toEntity(final LoanRequest domainLoanRequest);

    @Mapping(source = "id", target= "id")
    @Mapping(source = "customerName", target= "customerName")
    @Mapping(source = "amount", target= "amount")
    @Mapping(source = "badge", target= "badge")
    @Mapping(source = "dni", target= "dni")
    @Mapping(source = "state", target= "state")
    @Mapping(source = "createdAt", target = "createdAt")
    LoanResponse toResponse(final LoanRequest loanRequest);
}
