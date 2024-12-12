package com.example.practice.controller;

import com.example.practice.dto.DeliveryScheduleDTO;
import com.example.practice.service.DeliveryScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schedules")
@Validated
public class DeliveryScheduleController {

    private final DeliveryScheduleService service;

    public DeliveryScheduleController(DeliveryScheduleService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeliveryScheduleDTO> getAllSchedules() {
        return service.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryScheduleDTO> getScheduleById(@PathVariable Long id) {
        return service.getScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DeliveryScheduleDTO> createSchedule(@Valid @RequestBody DeliveryScheduleDTO scheduleDTO) {
        DeliveryScheduleDTO createdSchedule = service.createOrUpdateSchedule(scheduleDTO);
        return ResponseEntity.status(201).body(createdSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryScheduleDTO> updateSchedule(@PathVariable Long id, @Valid @RequestBody DeliveryScheduleDTO scheduleDTO) {
        return service.getScheduleById(id)
                .map(existing -> {
                    scheduleDTO.setId(id);
                    DeliveryScheduleDTO updatedSchedule = service.createOrUpdateSchedule(scheduleDTO);
                    return ResponseEntity.ok(updatedSchedule);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        if (service.getScheduleById(id).isPresent()) {
            service.deleteSchedule(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/week")
    public ResponseEntity<Map<String, List<DeliveryScheduleDTO>>> getWeeklySchedule() {
        Map<String, List<DeliveryScheduleDTO>> schedule = service.getWeeklySchedule();
        return ResponseEntity.ok(schedule);
    }
}
