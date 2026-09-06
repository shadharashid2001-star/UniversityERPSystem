package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Course;
import com.example.UniversityERPSystem.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServices {

    CourseRepository courseRepository;

    @Autowired
    public CourseServices(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Long createCourse(
            String title,
            String courseCode,
            Integer creditHours) {

        Course course = new Course();

        course.setActive(true);
        course.setCreatedDate(new Date());
        course.setTitle(title);
        course.setCourseCode(courseCode);
        course.setCreditHours(creditHours);

        course = courseRepository.save(course);

        return course.getId();
    }

    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    public Course getById(Long id) {

        Course course = courseRepository.getById(id);

        if (course != null) {
            return course;
        }

        return null;
    }

    public Course updateCourse(
            Long id,
            String title,
            String courseCode,
            Integer creditHours) throws Exception {

        Course courseToUpdate = courseRepository.getById(id);

        if (courseToUpdate == null) {
            throw new Exception("Course is not found by the id");
        }

        courseToUpdate.setTitle(title);
        courseToUpdate.setCourseCode(courseCode);
        courseToUpdate.setCreditHours(creditHours);
        courseToUpdate.setUpdatedDate(new Date());

        courseToUpdate = courseRepository.save(courseToUpdate);

        return courseToUpdate;
    }

    public Boolean deleteById(Long id) {

        Course courseToUpdate = courseRepository.getById(id);

        if (courseToUpdate == null) {
            return false;
        }

        courseToUpdate.setActive(false);
        courseToUpdate.setUpdatedDate(new Date());

        courseRepository.save(courseToUpdate);

        return true;
    }
}