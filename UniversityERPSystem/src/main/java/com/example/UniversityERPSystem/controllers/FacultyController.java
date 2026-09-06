package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.Entities.Faculty;
import com.example.UniversityERPSystem.Services.FacultyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    FacultyServices facultyServices;

    @Autowired
    public FacultyController(FacultyServices facultyServices) {
        this.facultyServices = facultyServices;
    }

    @PostMapping("add")
    public Long createFaculty(
            @RequestParam String name,
            @RequestParam String description) {

        return facultyServices.createFaculty(name, description);
    }

    @GetMapping("getAll")
    public List<Faculty> getAllFaculty() {
        return facultyServices.getAllFaculty();
    }

    @GetMapping("getById")
    public Faculty getById(@RequestParam Long id) {
        return facultyServices.getById(id);
    }

    @PutMapping("update")
    public Faculty updateFaculty(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String description) throws Exception {

        return facultyServices.updateFaculty(id, name, description);
    }

    @DeleteMapping("delete")
    public Boolean deleteFaculty(@RequestParam Long id) {
        return facultyServices.deleteById(id);
    }
}