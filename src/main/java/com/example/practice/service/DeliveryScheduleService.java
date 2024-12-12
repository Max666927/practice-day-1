package com.example.practice.service;

import com.example.practice.Entity.DeliverySchedule;
import com.example.practice.dto.DeliveryScheduleDTO;
import com.example.practice.repository.DeliveryScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryScheduleService {
    private final DeliveryScheduleRepository repository;

    public DeliveryScheduleService(DeliveryScheduleRepository repository) {
        this.repository = repository;
    }

    public List<DeliveryScheduleDTO> getAllSchedules() {
        List<DeliverySchedule> schedules = repository.findAll();
        return schedules.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<DeliverySchedule> getScheduleById(Long id) {
        return repository.findById(id);
    }

    public DeliveryScheduleDTO createOrUpdateSchedule(DeliveryScheduleDTO dto) {
        DeliverySchedule entity = new DeliverySchedule();
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setAdditionalInfo(dto.getAdditionalInfo());
        DeliverySchedule savedEntity = repository.save(entity);
        return convertToDto(savedEntity);
    }

    public void deleteSchedule(Long id) {
        repository.deleteById(id);
    }

    public Map<String, List<DeliveryScheduleDTO>> getWeeklySchedule() {
        List<DeliverySchedule> schedules = repository.findAll();
        return schedules.stream()
                .map(this::convertToDto)
                .collect(Collectors.groupingBy(DeliveryScheduleDTO::getDayOfWeek));
    }

    private DeliveryScheduleDTO convertToDto(DeliverySchedule schedule) {
        DeliveryScheduleDTO dto = new DeliveryScheduleDTO();
        dto.setDayOfWeek(schedule.getDayOfWeek());
        dto.setDeliveryTime(schedule.getDeliveryTime());
        dto.setAdditionalInfo(schedule.getAdditionalInfo());
        return dto;
    }
}
