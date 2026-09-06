package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d WHERE d.isActive = true")
    List<Department> getAllDepartment();

    @Query("SELECT d FROM Department d WHERE d.isActive = true AND d.id = :id")
    Department getById(@Param("id") Long id);
}