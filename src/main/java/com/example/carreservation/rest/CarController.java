package com.example.carreservation.rest;

import com.example.carreservation.dto.CarDto;
import com.example.carreservation.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<String> post(@RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.create(carDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> put(@PathVariable Long id, @RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.update(id, carDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(carService.delete(id));
    }
}
