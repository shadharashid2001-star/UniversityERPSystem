package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.DTOs.StudentDTO;
import com.example.UniversityERPSystem.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @PostMapping("add")
    public Long createStudent(@RequestParam String name,
                              @RequestParam String major,
                              @RequestParam String gender,
                              @RequestParam String phoneNumber,
                              @RequestParam Long programId) throws Exception {

        return studentServices.createStudent(
                name,
                major,
                gender,
                phoneNumber,
                programId
        );
    }

    @GetMapping("getAll")
    public List<StudentDTO> getAllStudent() {

        return StudentDTO.convertToDTO(
                studentServices.getAllStudent()
        );
    }

    @GetMapping("getById")
    public StudentDTO getById(@RequestParam Long id) {

        return StudentDTO.convertToDTO(
                studentServices.getById(id)
        );
    }

    @PutMapping("update")
    public StudentDTO updateStudent(@RequestParam Long id,
                                    @RequestParam String name,
                                    @RequestParam String major,
                                    @RequestParam String gender,
                                    @RequestParam String phoneNumber,
                                    @RequestParam Long programId) throws Exception {

        return StudentDTO.convertToDTO(
                studentServices.updateStudent(
                        id,
                        name,
                        major,
                        gender,
                        phoneNumber,
                        programId
                )
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteStudent(@RequestParam Long id) {
        return studentServices.deleteById(id);
    }
}