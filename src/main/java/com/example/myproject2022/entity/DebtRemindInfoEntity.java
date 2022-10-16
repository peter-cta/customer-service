package com.example.myproject2022.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "debt_remind_info", schema = "example", catalog = "")
public class DebtRemindInfoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "debt_id")
    private String debtId;
    @Basic
    @Column(name = "created_date")
    private Date createdDate;
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

    public String getDebtId() {
        return debtId;
    }

    public void setDebtId(String debtId) {
        this.debtId = debtId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Time getDateTime() {
        return dateTime;
    }

    public void setDateTime(Time dateTime) {
        this.dateTime = dateTime;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDpd() {
        return dpd;
    }

    public void setDpd(Integer dpd) {
        this.dpd = dpd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebtRemindInfoEntity that = (DebtRemindInfoEntity) o;
        return Objects.equals(debtId, that.debtId) && Objects.equals(createdDate, that.createdDate) && Objects.equals(dateTime, that.dateTime) && Objects.equals(contractNumber, that.contractNumber) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(dpd, that.dpd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(debtId, createdDate, dateTime, contractNumber, phoneNumber, dpd);
    }
}
