package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    @Query("SELECT u FROM University u WHERE u.isActive = true")
    List<University> getAllUniversity();

    @Query("SELECT u FROM University u WHERE u.isActive = true AND u.id = :id")
    University getById(@Param("id") Long id);
}