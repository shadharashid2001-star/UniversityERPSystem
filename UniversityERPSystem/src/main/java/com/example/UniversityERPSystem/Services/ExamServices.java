package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Course;
import com.example.UniversityERPSystem.Entities.Exam;
import com.example.UniversityERPSystem.Repositories.CourseRepository;
import com.example.UniversityERPSystem.Repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExamServices {

    ExamRepository examRepository;
    CourseRepository courseRepository;

    @Autowired
    public ExamServices(ExamRepository examRepository,
                        CourseRepository courseRepository) {
        this.examRepository = examRepository;
        this.courseRepository = courseRepository;
    }

    public Long createExam(String title,
                           Date examDate,
                           Integer totalMarks,
                           Long courseId) throws Exception {

        Course course = courseRepository.getById(courseId);

        if (course == null) {
            throw new Exception("Course is not found by the id");
        }

        Exam exam = new Exam();

        exam.setActive(true);
        exam.setCreatedDate(new Date());
        exam.setTitle(title);
        exam.setExamDate(examDate);
        exam.setTotalMarks(totalMarks);
        exam.setCourse(course);

        exam = examRepository.save(exam);

        return exam.getId();
    }

    public List<Exam> getAllExam() {
        return examRepository.getAllExam();
    }

    public Exam getById(Long id) {
        return examRepository.getById(id);
    }

    public Exam updateExam(Long id,
                           String title,
                           Date examDate,
                           Integer totalMarks,
                           Long courseId) throws Exception {

        Exam examToUpdate = examRepository.getById(id);

        if (examToUpdate == null) {
            throw new Exception("Exam is not found by the id");
        }

        Course course = courseRepository.getById(courseId);

        if (course == null) {
            throw new Exception("Course is not found by the id");
        }

        examToUpdate.setTitle(title);
        examToUpdate.setExamDate(examDate);
        examToUpdate.setTotalMarks(totalMarks);
        examToUpdate.setCourse(course);
        examToUpdate.setUpdatedDate(new Date());

        return examRepository.save(examToUpdate);
    }

    public Boolean deleteById(Long id) {

        Exam examToDelete = examRepository.getById(id);

        if (examToDelete == null) {
            return false;
        }

        examToDelete.setActive(false);
        examToDelete.setUpdatedDate(new Date());

        examRepository.save(examToDelete);

        return true;
    }
}