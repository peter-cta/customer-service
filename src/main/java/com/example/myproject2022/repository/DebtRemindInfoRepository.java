package com.example.myproject2022.repository;

import com.example.myproject2022.entity.DebtRemindInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DebtRemindInfoRepository extends JpaRepository<DebtRemindInfoEntity, String> {

    List<DebtRemindInfoEntity> findAllByCreatedDate(LocalDate localDate);
}
