package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.Entities.Instructor;
import com.example.UniversityERPSystem.Services.InstructorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instructor")
public class InstructorController {

    InstructorServices instructorServices;

    @Autowired
    public InstructorController(InstructorServices instructorServices) {
        this.instructorServices = instructorServices;
    }

    @PostMapping("add")
    public Long createInstructor(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String specialization
   , @RequestParam Long depId) {

        return instructorServices.createInstructor(
                name,
                email,
                phoneNumber,
                specialization,
                depId
        );
    }

    @GetMapping("getAll")
    public List<Instructor> getAllInstructor() {
        return instructorServices.getAllInstructor();
    }

    @GetMapping("getById")
    public Instructor getById(@RequestParam Long id) {
        return instructorServices.getById(id);
    }

    @PutMapping("update")
    public Instructor updateInstructor(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String specialization) throws Exception {

        return instructorServices.updateInstructor(
                id,
                name,
                email,
                phoneNumber,
                specialization
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteInstructor(@RequestParam Long id) {
        return instructorServices.deleteById(id);
    }
}