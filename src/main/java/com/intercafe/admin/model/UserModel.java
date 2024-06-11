package com.intercafe.admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class UserModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false) @JdbcTypeCode(SqlTypes.BIGINT) private Long id;
    @Column(name = "USERNAME") private String userName;
    @Column(name = "NAME") private String name;
    @Column(name = "SURNAME") private String surname;
    @Column(name = "PASSWORD") private String password;
    @Column(name = "ROLE") private String role;
}
