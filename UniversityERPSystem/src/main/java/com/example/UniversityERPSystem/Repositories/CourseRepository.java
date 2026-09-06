package com.example.UniversityERPSystem.Repositories;

import com.example.UniversityERPSystem.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.isActive = true")
    List<Course> getAllCourse();

    @Query("SELECT c FROM Course c WHERE c.isActive = true AND c.id = :id")
    Course getById(@Param("id") Long id);
}