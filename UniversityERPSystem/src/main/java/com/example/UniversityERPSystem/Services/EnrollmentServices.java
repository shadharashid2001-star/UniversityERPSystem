package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Course;
import com.example.UniversityERPSystem.Entities.Enrollment;
import com.example.UniversityERPSystem.Entities.Student;
import com.example.UniversityERPSystem.Repositories.CourseRepository;
import com.example.UniversityERPSystem.Repositories.EnrollmentRepository;
import com.example.UniversityERPSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnrollmentServices {

    EnrollmentRepository enrollmentRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    @Autowired
    public EnrollmentServices(EnrollmentRepository enrollmentRepository,
                              StudentRepository studentRepository,
                              CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Long createEnrollment(Date enrollmentDate,
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

    public Enrollment updateEnrollment(Long id,
                                       Date enrollmentDate,
                                       String status,
                                       Long studentId,
                                       Long courseId) throws Exception {

        Enrollment enrollmentToUpdate = enrollmentRepository.getById(id);

        if (enrollmentToUpdate == null) {
            throw new Exception("Enrollment is not found by the id");
        }

        Student student = studentRepository.getById(studentId);

        if (student == null) {
            throw new Exception("Student is not found by the id");
        }

        Course course = courseRepository.getById(courseId);

        if (course == null) {
            throw new Exception("Course is not found by the id");
        }

        enrollmentToUpdate.setEnrollmentDate(enrollmentDate);
        enrollmentToUpdate.setStatus(status);
        enrollmentToUpdate.setStudent(student);
        enrollmentToUpdate.setCourse(course);
        enrollmentToUpdate.setUpdatedDate(new Date());

        return enrollmentRepository.save(enrollmentToUpdate);
    }

    public Boolean deleteById(Long id) {

        Enrollment enrollmentToDelete = enrollmentRepository.getById(id);

        if (enrollmentToDelete == null) {
            return false;
        }

        enrollmentToDelete.setActive(false);
        enrollmentToDelete.setUpdatedDate(new Date());

        enrollmentRepository.save(enrollmentToDelete);

        return true;
    }
}