package com.example.UniversityERPSystem.Controllers;
import com.example.UniversityERPSystem.Entities.Student;
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

    @PostMapping("/add")
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
    public List<Student> getAllStudent() {
        return studentServices.getAllStudent();
    }

    @GetMapping("getById")
    public Student getById(@RequestParam Long id) {
        return studentServices.getById(id);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String major,
                                 @RequestParam String gender,
                                 @RequestParam String phoneNumber,
                                 @RequestParam Long programId) throws Exception {

        return studentServices.updateStudent(
                id,
                name,
                major,
                gender,
                phoneNumber,
                programId
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteStudent(@RequestParam Long id) {
        return studentServices.deleteById(id);
    }
}