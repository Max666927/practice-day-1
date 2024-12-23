package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @GetMapping("/week")
    public ResponseEntity<Map<String, List<String>>> getWeeklySchedule() {
        // Сервіс для отримання розкладу
        Map<String, List<String>> schedule = Map.of(
                "Monday", List.of("Task 1", "Task 2"),
                "Tuesday", List.of("Task 3")
        );

        return ResponseEntity.ok(schedule);
    }
}
