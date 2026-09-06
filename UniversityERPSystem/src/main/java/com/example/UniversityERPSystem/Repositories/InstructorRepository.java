package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Query("SELECT i FROM Instructor i WHERE i.isActive = true")
    List<Instructor> getAllInstructor();

    @Query("SELECT i FROM Instructor i WHERE i.isActive = true AND i.id = :id")
    Instructor getById(@Param("id") Long id);
}