package com.example.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "username",nullable = false,unique = true)
    private String name;
    private Integer age;
//    @Column(unique = true)
    private String phone;
    private String email;
}