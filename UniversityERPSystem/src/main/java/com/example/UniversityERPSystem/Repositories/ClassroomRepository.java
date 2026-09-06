package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @Query("SELECT c FROM Classroom c WHERE c.isActive = true")
    List<Classroom> getAllClassroom();

    @Query("SELECT c FROM Classroom c WHERE c.isActive = true AND c.id = :id")
    Classroom getById(@Param("id") Long id);
}