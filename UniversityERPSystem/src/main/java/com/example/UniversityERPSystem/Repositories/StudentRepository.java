package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Program;
import com.example.UniversityERPSystem.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT p FROM Student p WHERE p.isActive = true")
    List<Student> getAllStudent();

    @Query("SELECT p FROM Student p WHERE p.isActive = true AND p.id = :id")
    Student getById(@Param("id") Long id);
}
