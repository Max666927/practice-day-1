package com.example.practice.controller;

import com.example.practice.DeliverySchedule;
import com.example.practice.entity.DeliverySchedule;
import com.example.practice.service.DeliveryScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class DeliveryScheduleController {
    private final DeliveryScheduleService service;

    public DeliveryScheduleController(DeliveryScheduleService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeliverySchedule> getAllSchedules() {
        return service.getAllSchedules();
    }

    @GetMapping("/{id}")
    public DeliverySchedule getScheduleById(@PathVariable Long id) {
        return service.getScheduleById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    @PostMapping
    public DeliverySchedule createSchedule(@RequestBody DeliverySchedule schedule) {
        return service.createOrUpdateSchedule(schedule);
    }

    @PutMapping("/{id}")
    public DeliverySchedule updateSchedule(@PathVariable Long id, @RequestBody DeliverySchedule schedule) {
        schedule.setId(id);
        return service.createOrUpdateSchedule(schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        service.deleteSchedule(id);
    }
}
