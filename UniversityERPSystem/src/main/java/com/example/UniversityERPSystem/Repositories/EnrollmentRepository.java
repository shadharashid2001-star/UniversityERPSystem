package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("SELECT e FROM Enrollment e WHERE e.isActive = true")
    List<Enrollment> getAllEnrollment();

    @Query("SELECT e FROM Enrollment e WHERE e.isActive = true AND e.id = :id")
    Enrollment getById(@Param("id") Long id);
}