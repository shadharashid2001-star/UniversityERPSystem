package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.DTOs.FacultyDTO;
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
    public List<FacultyDTO> getAllFaculty() {

        return FacultyDTO.convertToDTO(
                facultyServices.getAllFaculty()
        );
    }

    @GetMapping("getById")
    public FacultyDTO getById(@RequestParam Long id) {

        return FacultyDTO.convertToDTO(
                facultyServices.getById(id)
        );
    }

    @PutMapping("update")
    public FacultyDTO updateFaculty(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String description) throws Exception {

        return FacultyDTO.convertToDTO(
                facultyServices.updateFaculty(
                        id,
                        name,
                        description
                )
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteFaculty(@RequestParam Long id) {

        return facultyServices.deleteById(id);
    }
}