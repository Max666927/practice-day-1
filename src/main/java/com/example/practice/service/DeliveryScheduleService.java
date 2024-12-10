package com.example.practice.service;

import com.example.practice.DeliverySchedule;
import com.example.practice.repository.DeliveryScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryScheduleService {
    private final DeliveryScheduleRepository repository;

    public DeliveryScheduleService(DeliveryScheduleRepository repository) {
        this.repository = repository;
    }

    public List<DeliverySchedule> getAllSchedules() {
        return repository.findAll();
    }

    public Optional<DeliverySchedule> getScheduleById(Long id) {
        return repository.findById(id);
    }

    public DeliverySchedule createOrUpdateSchedule(DeliverySchedule schedule) {
        return repository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        repository.deleteById(id);
    }
}
