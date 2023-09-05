package com.example.carreservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private String description;
    @Builder.Default
    private List<String> photoUrls = new ArrayList<>();
}
