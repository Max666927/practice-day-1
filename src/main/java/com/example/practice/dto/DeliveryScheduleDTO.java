package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DeliveryScheduleDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String deliveryDate;

    @NotBlank
    private String supplier;

    // Геттери/сеттери
}
