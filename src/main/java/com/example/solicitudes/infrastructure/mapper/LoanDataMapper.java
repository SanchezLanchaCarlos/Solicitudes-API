package com.example.solicitudes.infrastructure.mapper;

import com.example.solicitudes.domain.requests.CreateRequestQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.CreateLoanData;
import org.openapitools.model.UpdateLoanData;

@Mapper(componentModel = "spring", uses = { DateMapper.class })
public interface LoanDataMapper {

    @Mapping(source = "customerName", target= "customerName")
    @Mapping(source = "amount", target= "amount")
    @Mapping(source = "badge", target= "badge")
    @Mapping(source = "dni", target= "dni")
    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "toLocalDate")
    CreateRequestQuery toCreateRequestQuery(CreateLoanData loanData);

    @Mapping(source = "customerName", target= "customerName")
    @Mapping(source = "amount", target= "amount")
    @Mapping(source = "badge", target= "badge")
    @Mapping(source = "dni", target= "dni")
    @Mapping(source = "state", target= "state")
    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "toLocalDate")
    CreateRequestQuery toUpdateRequestQuery(UpdateLoanData loanData);
}
