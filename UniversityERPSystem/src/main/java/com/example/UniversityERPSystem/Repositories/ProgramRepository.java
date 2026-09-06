package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

    @Query("SELECT p FROM Program p WHERE p.isActive = true")
    List<Program> getAllProgram();

    @Query("SELECT p FROM Program p WHERE p.isActive = true AND p.id = :id")
    Program getById(@Param("id") Long id);
}