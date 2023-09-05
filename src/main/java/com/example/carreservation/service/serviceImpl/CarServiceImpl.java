package com.example.carreservation.service.serviceImpl;

import com.example.carreservation.dto.CarDto;
import com.example.carreservation.mapper.CarMapper;
import com.example.carreservation.model.Car;
import com.example.carreservation.repository.CarRepository;
import com.example.carreservation.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Transactional(readOnly = true)
    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll().stream().map(carMapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public CarDto findById(Long id) {
        return carRepository.findById(id).map(carMapper::toDto).get();
    }

    @Transactional
    @Override
    public String create(CarDto carDto) {
        carRepository.save(carMapper.toEntity(carDto));
        return "Success";
    }

    @Transactional
    @Override
    public CarDto update(Long id, CarDto carDto) {
        Car currentCar = carRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(String.format("Car with id = %d does not exist", id))
        );
        Car newInfoCar = carMapper.toEntity(carDto);

        if (!currentCar.getId().equals(newInfoCar.getId()) && newInfoCar.getId() != null) {
            throw new IllegalArgumentException("Not the same id");
        }

        currentCar.setModel(newInfoCar.getModel());
        currentCar.setBrand(newInfoCar.getBrand());
        currentCar.setDescription(newInfoCar.getDescription());
        currentCar.setPhotoUrls(newInfoCar.getPhotoUrls());
        carRepository.save(currentCar);

        return carMapper.toDto(currentCar);
    }

    @Transactional
    @Override
    public String delete(Long id) {
        boolean exist = carRepository.existsById(id);
        if (!exist) throw new IllegalArgumentException(String.format("Car with id = %d does not exist", id));
        carRepository.deleteById(id);
        return "Success";
    }
}
