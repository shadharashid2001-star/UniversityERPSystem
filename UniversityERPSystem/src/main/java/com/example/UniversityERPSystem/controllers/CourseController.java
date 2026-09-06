package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.DTOs.CourseDTO;
import com.example.UniversityERPSystem.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    CourseServices courseServices;

    @Autowired
    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    @PostMapping("add")
    public Long createCourse(
            @RequestParam String title,
            @RequestParam String courseCode,
            @RequestParam Integer creditHours) {

        return courseServices.createCourse(
                title,
                courseCode,
                creditHours
        );
    }

    @GetMapping("getAll")
    public List<CourseDTO> getAllCourse() {

        return CourseDTO.convertToDTO(
                courseServices.getAllCourse()
        );
    }

    @GetMapping("getById")
    public CourseDTO getById(@RequestParam Long id) {

        return CourseDTO.convertToDTO(
                courseServices.getById(id)
        );
    }

    @PutMapping("update")
    public CourseDTO updateCourse(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam String courseCode,
            @RequestParam Integer creditHours) throws Exception {

        return CourseDTO.convertToDTO(
                courseServices.updateCourse(
                        id,
                        title,
                        courseCode,
                        creditHours
                )
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteCourse(@RequestParam Long id) {

        return courseServices.deleteById(id);
    }
}