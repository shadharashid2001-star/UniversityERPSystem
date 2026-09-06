package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("SELECT g FROM Grade g WHERE g.isActive = true")
    List<Grade> getAllGrade();

    @Query("SELECT g FROM Grade g WHERE g.isActive = true AND g.id = :id")
    Grade getById(@Param("id") Long id);
}