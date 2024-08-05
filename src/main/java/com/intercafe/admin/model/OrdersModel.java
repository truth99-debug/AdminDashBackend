package com.intercafe.admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
@Getter @Setter
public class OrdersModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false) @JdbcTypeCode(SqlTypes.BIGINT) private Long id;
    @JoinColumn(name = "USER_ID") @ManyToOne private UserModel userModel;
    @JoinColumn(name = "MEAL_ITEM") @ManyToOne private MealModel mealModel;
    @Column(name = "STATUS") private String status;
    @Column(name = "DATE") private LocalDate date;
}
