package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    @Query("SELECT f FROM Faculty f WHERE f.isActive = true")
    List<Faculty> getAllFaculty();

    @Query("SELECT f FROM Faculty f WHERE f.isActive = true AND f.id = :id")
    Faculty getById(@Param("id") Long id);
}