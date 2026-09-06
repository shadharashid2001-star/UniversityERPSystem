package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Enrollment;
import com.example.UniversityERPSystem.Entities.Exam;
import com.example.UniversityERPSystem.Entities.Grade;
import com.example.UniversityERPSystem.Repositories.EnrollmentRepository;
import com.example.UniversityERPSystem.Repositories.ExamRepository;
import com.example.UniversityERPSystem.Repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GradeServices {

    GradeRepository gradeRepository;
    EnrollmentRepository enrollmentRepository;
    ExamRepository examRepository;

    @Autowired
    public GradeServices(GradeRepository gradeRepository,
                         EnrollmentRepository enrollmentRepository,
                         ExamRepository examRepository) {
        this.gradeRepository = gradeRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.examRepository = examRepository;
    }

    public Long createGrade(Integer score,
                            String letterGrade,
                            Long enrollmentId,
                            Long examId) throws Exception {

        Enrollment enrollment = enrollmentRepository.getById(enrollmentId);

        if (enrollment == null) {
            throw new Exception("Enrollment is not found by the id");
        }

        Exam exam = examRepository.getById(examId);

        if (exam == null) {
            throw new Exception("Exam is not found by the id");
        }

        Grade grade = new Grade();

        grade.setActive(true);
        grade.setCreatedDate(new Date());
        grade.setScore(score);
        grade.setLetterGrade(letterGrade);
        grade.setEnrollment(enrollment);
        grade.setExam(exam);

        grade = gradeRepository.save(grade);

        return grade.getId();
    }

    public List<Grade> getAllGrade() {
        return gradeRepository.getAllGrade();
    }

    public Grade getById(Long id) {
        return gradeRepository.getById(id);
    }

    public Grade updateGrade(Long id,
                             Integer score,
                             String letterGrade,
                             Long enrollmentId,
                             Long examId) throws Exception {

        Grade gradeToUpdate = gradeRepository.getById(id);

        if (gradeToUpdate == null) {
            throw new Exception("Grade is not found by the id");
        }

        Enrollment enrollment = enrollmentRepository.getById(enrollmentId);

        if (enrollment == null) {
            throw new Exception("Enrollment is not found by the id");
        }

        Exam exam = examRepository.getById(examId);

        if (exam == null) {
            throw new Exception("Exam is not found by the id");
        }

        gradeToUpdate.setScore(score);
        gradeToUpdate.setLetterGrade(letterGrade);
        gradeToUpdate.setEnrollment(enrollment);
        gradeToUpdate.setExam(exam);
        gradeToUpdate.setUpdatedDate(new Date());

        return gradeRepository.save(gradeToUpdate);
    }

    public Boolean deleteById(Long id) {

        Grade gradeToDelete = gradeRepository.getById(id);

        if (gradeToDelete == null) {
            return false;
        }

        gradeToDelete.setActive(false);
        gradeToDelete.setUpdatedDate(new Date());

        gradeRepository.save(gradeToDelete);

        return true;
    }
}