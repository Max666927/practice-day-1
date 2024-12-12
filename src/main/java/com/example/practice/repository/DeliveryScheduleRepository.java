package com.example.practice.repository;

import com.example.practice.Entity.DeliverySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryScheduleRepository extends JpaRepository<DeliverySchedule, Long> {
}
