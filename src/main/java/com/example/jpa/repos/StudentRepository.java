package com.example.jpa.repos;

import com.example.jpa.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository
        // JpaRepository< 내가 사용할 Entity, 그 Entity의 ID 칼럼의 타입>
        extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findAllByOrderByName();

    List<StudentEntity> findAllByOrderByAgeDesc();

    List<StudentEntity> findAllByAgeLessThan(Integer age);

    List<StudentEntity> findAllByPhoneStartingWith(String phone);

}
