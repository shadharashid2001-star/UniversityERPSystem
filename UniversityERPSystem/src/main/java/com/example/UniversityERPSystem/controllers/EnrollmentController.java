package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.DTOs.EnrollmentDTO;
import com.example.UniversityERPSystem.Services.EnrollmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("enrollment")
public class EnrollmentController {

    EnrollmentServices enrollmentServices;

    @Autowired
    public EnrollmentController(EnrollmentServices enrollmentServices) {
        this.enrollmentServices = enrollmentServices;
    }

    @PostMapping("add")
    public Long createEnrollment(
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date enrollmentDate,
            @RequestParam String status,
            @RequestParam Long studentId,
            @RequestParam Long courseId) throws Exception {

        return enrollmentServices.createEnrollment(
                enrollmentDate,
                status,
                studentId,
                courseId
        );
    }

    @GetMapping("getAll")
    public List<EnrollmentDTO> getAllEnrollment() {

        return EnrollmentDTO.convertToDTO(
                enrollmentServices.getAllEnrollment()
        );
    }

    @GetMapping("getById")
    public EnrollmentDTO getById(@RequestParam Long id) {

        return EnrollmentDTO.convertToDTO(
                enrollmentServices.getById(id)
        );
    }

    @PutMapping("update")
    public EnrollmentDTO updateEnrollment(
            @RequestParam Long id,
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date enrollmentDate,
            @RequestParam String status,
            @RequestParam Long studentId,
            @RequestParam Long courseId) throws Exception {

        return EnrollmentDTO.convertToDTO(
                enrollmentServices.updateEnrollment(
                        id,
                        enrollmentDate,
                        status,
                        studentId,
                        courseId
                )
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteEnrollment(@RequestParam Long id) {

        return enrollmentServices.deleteById(id);
    }
    @PostMapping("enroll")
    public EnrollmentDTO enrollStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId) throws Exception {

        return EnrollmentDTO.convertToDTO(
                enrollmentServices.enrollStudent(
                        studentId,
                        courseId
                )
        );
    }
}