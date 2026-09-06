package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, Long> {

    @Query("SELECT g FROM Guardian g WHERE g.isActive = true")
    List<Guardian> getAllGuardian();

    @Query("SELECT g FROM Guardian g WHERE g.isActive = true AND g.id = :id")
    Guardian getById(@Param("id") Long id);
}