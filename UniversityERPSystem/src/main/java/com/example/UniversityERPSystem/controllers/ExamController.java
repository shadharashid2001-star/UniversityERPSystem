package com.example.UniversityERPSystem.controllers;
import com.example.UniversityERPSystem.Entities.Exam;
import com.example.UniversityERPSystem.Services.ExamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("exam")
public class ExamController {

    ExamServices examServices;

    @Autowired
    public ExamController(ExamServices examServices) {
        this.examServices = examServices;
    }

    @PostMapping("add")
    public Long createExam(
            @RequestParam String title,
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date examDate,
            @RequestParam Integer totalMarks,
            @RequestParam Long courseId) throws Exception {

        return examServices.createExam(
                title,
                examDate,
                totalMarks,
                courseId
        );
    }

    @GetMapping("getAll")
    public List<Exam> getAllExam() {
        return examServices.getAllExam();
    }

    @GetMapping("getById")
    public Exam getById(@RequestParam Long id) {
        return examServices.getById(id);
    }

    @PutMapping("update")
    public Exam updateExam(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date examDate,
            @RequestParam Integer totalMarks,
            @RequestParam Long courseId) throws Exception {

        return examServices.updateExam(
                id,
                title,
                examDate,
                totalMarks,
                courseId
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteExam(@RequestParam Long id) {
        return examServices.deleteById(id);
    }
}