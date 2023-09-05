package com.example.carreservation.service;

import com.example.carreservation.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> findAll();

    CarDto findById(Long id);

    String create(CarDto carDto);

    CarDto update(Long id, CarDto carDto);

    String delete(Long id);
}
