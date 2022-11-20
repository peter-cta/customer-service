package com.example.myproject2022.repository;

import com.example.myproject2022.entity.DebtRemindInfo2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DebtRemindInfo2Repository extends JpaRepository<DebtRemindInfo2Entity, String> {

    List<DebtRemindInfo2Entity> findAllByCreatedDate(LocalDate localDate);
}
