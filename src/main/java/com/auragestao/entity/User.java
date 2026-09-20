package com.auragestao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.swing.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Generated
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name="created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Generated
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false, length = 1)
    private Integer typeUser;

}