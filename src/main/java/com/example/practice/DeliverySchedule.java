package com.example.practice;

import java.time.LocalDate;

public class DeliverySchedule {
    private Long id;

    private Product product;

    private Supplier supplier;

    private Store store;

    private int deliveryNumber;
    private LocalDate deliveryDate;
    private int quantity;
    private String additionalInfo;
}
