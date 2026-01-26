package com.example.solicitudes.infrastructure.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface DateMapper {

    @Named("toLocalDate")
    default LocalDate toLocalDate(String value) {
        if (value == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );

        if (value.contains("-")) {
            return LocalDate.parse(value);
        }

        return LocalDate.parse(value, formatter);
    }
}
