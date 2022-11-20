package com.example.myproject2022.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "debt_remind_info2", schema = "example", catalog = "")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DebtRemindInfo2Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "debt_id")
    private Integer debtId;
    @Basic
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Basic
    @Column(name = "date_time")
    private Time dateTime;
    @Basic
    @Column(name = "contract_number")
    private String contractNumber;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "dpd")
    private Integer dpd;

}
