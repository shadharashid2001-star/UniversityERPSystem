package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Course;
import com.example.UniversityERPSystem.Entities.Enrollment;
import com.example.UniversityERPSystem.Entities.Student;
import com.example.UniversityERPSystem.Repositories.CourseRepository;
import com.example.UniversityERPSystem.Repositories.EnrollmentRepository;
import com.example.UniversityERPSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnrollmentServices {

    EnrollmentRepository enrollmentRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    @Autowired
    public EnrollmentServices(
            EnrollmentRepository enrollmentRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository) {

        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Long createEnrollment(
            Date enrollmentDate,
            String status,
            Long studentId,
            Long courseId) throws Exception {

        Student student = studentRepository.getById(studentId);

        if (student == null) {
            throw new Exception("Student is not found by the id");
        }

        Course course = courseRepository.getById(courseId);

        if (course == null) {
            throw new Exception("Course is not found by the id");
        }

        Enrollment enrollment = new Enrollment();

        enrollment.setActive(true);
        enrollment.setCreatedDate(new Date());
        enrollment.setEnrollmentDate(enrollmentDate);
        enrollment.setStatus(status);
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        enrollment = enrollmentRepository.save(enrollment);

        return enrollment.getId();
    }

    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.getAllEnrollment();
    }

    public Enrollment getById(Long id) {
        return enrollmentRepository.getById(id);
    }

    public Enrollment updateEnrollment(
            Long id,
            Date enrollmentDate,
            String status,
            Long studentId,
            Long courseId) throws Exception {

        Enrollment enrollmentToUpdate =
                enrollmentRepository.getById(id);

        if (enrollmentToUpdate == null) {
            throw new Exception(
                    "Enrollment is not found by the id"
            );
        }

        Student student =
                studentRepository.getById(studentId);

        if (student == null) {
            throw new Exception(
                    "Student is not found by the id"
            );
        }

        Course course =
                courseRepository.getById(courseId);

        if (course == null) {
            throw new Exception(
                    "Course is not found by the id"
            );
        }

        enrollmentToUpdate.setEnrollmentDate(enrollmentDate);
        enrollmentToUpdate.setStatus(status);
        enrollmentToUpdate.setStudent(student);
        enrollmentToUpdate.setCourse(course);
        enrollmentToUpdate.setUpdatedDate(new Date());

        return enrollmentRepository.save(enrollmentToUpdate);
    }

    public Boolean deleteById(Long id) {

        Enrollment enrollmentToDelete =
                enrollmentRepository.getById(id);

        if (enrollmentToDelete == null) {
            return false;
        }

        enrollmentToDelete.setActive(false);
        enrollmentToDelete.setUpdatedDate(new Date());

        enrollmentRepository.save(enrollmentToDelete);

        return true;
    }

    // Phase 4 - Task 1
    public Enrollment enrollStudent(
            Long studentId,
            Long courseId) throws Exception {

        Student student =
                studentRepository.getById(studentId);

        if (student == null) {
            throw new Exception(
                    "Student not found or inactive"
            );
        }

        Course course =
                courseRepository.getById(courseId);

        if (course == null) {
            throw new Exception(
                    "Course not found or inactive"
            );
        }

        Enrollment existingEnrollment =
                enrollmentRepository.findActiveEnrollment(
                        studentId,
                        courseId
                );

        if (existingEnrollment != null) {
            throw new Exception(
                    "Student is already enrolled in this course"
            );
        }

        if (course.getClassroom() == null) {
            throw new Exception(
                    "Course does not have an assigned classroom"
            );
        }

        Integer capacity =
                course.getClassroom().getCapacity();

        if (capacity == null || capacity <= 0) {
            throw new Exception(
                    "Classroom capacity is invalid"
            );
        }

        Long currentEnrollments =
                enrollmentRepository
                        .countActiveEnrollmentsByCourse(courseId);

        if (currentEnrollments >= capacity) {
            throw new Exception("Course is full");
        }

        Enrollment enrollment = new Enrollment();

        enrollment.setActive(true);
        enrollment.setCreatedDate(new Date());
        enrollment.setEnrollmentDate(new Date());
        enrollment.setStatus("ENROLLED");
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    // Phase 4 - Task 2
    public Enrollment dropEnrollment(
            Long enrollmentId) throws Exception {

        Enrollment enrollment =
                enrollmentRepository.getById(enrollmentId);

        if (enrollment == null) {
            throw new Exception(
                    "Enrollment not found or inactive"
            );
        }

        enrollment.setStatus("DROPPED");
        enrollment.setActive(false);
        enrollment.setUpdatedDate(new Date());

        return enrollmentRepository.save(enrollment);
    }

    // Phase 4 - Task 2
    public List<Enrollment> getStudentCourses(
            Long studentId) throws Exception {

        Student student =
                studentRepository.getById(studentId);

        if (student == null) {
            throw new Exception(
                    "Student not found or inactive"
            );
        }

        return enrollmentRepository
                .getEnrollmentsByStudentId(studentId);
    }
    @Query("""
       SELECT COUNT(e) FROM Enrollment e
       WHERE e.course.id = :courseId
       AND e.isActive = true
       AND e.status = 'ENROLLED'
       """)
    Long countActiveEnrollmentsByCourse(
            @Param("courseId") Long courseId
    );
}