package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.Entities.Course;
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

        return courseServices.createCourse(title, courseCode, creditHours);
    }

    @GetMapping("getAll")
    public List<Course> getAllCourse() {

        return courseServices.getAllCourse();
    }

    @GetMapping("getById")
    public Course getById(@RequestParam Long id) {

        return courseServices.getById(id);
    }

    @PutMapping("/update")
    public Course updateCourse(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam String courseCode,
            @RequestParam Integer creditHours) throws Exception {

        return courseServices.updateCourse(
                id,
                title,
                courseCode,
                creditHours
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteCourse(@RequestParam Long id) {

        return courseServices.deleteById(id);
    }
}