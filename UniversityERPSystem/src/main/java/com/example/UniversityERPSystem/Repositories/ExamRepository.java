package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query("SELECT e FROM Exam e WHERE e.isActive = true")
    List<Exam> getAllExam();

    @Query("SELECT e FROM Exam e WHERE e.isActive = true AND e.id = :id")
    Exam getById(@Param("id") Long id);
}