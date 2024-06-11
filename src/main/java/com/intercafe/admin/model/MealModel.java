package com.intercafe.admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "MEAL_ITEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MealModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false) @JdbcTypeCode(SqlTypes.BIGINT) private Long id;
    @Column(name = "CATEGORY") private String category;
    @Column(name = "DESCRIPTION") private String description;
    @Column(name = "IMAGE") private String image;
    @Column(name = "NAME") private String name;
    @Column(name = "PRICE") private String price;
}
