package com.example.carreservation.mapper;

import com.example.carreservation.dto.CarDto;
import com.example.carreservation.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        implementationPackage = "com.example.carreservation.mapper.impl"
)
public interface CarMapper {

    CarDto toDto(Car car);

    Car toEntity(CarDto carDto);
}
