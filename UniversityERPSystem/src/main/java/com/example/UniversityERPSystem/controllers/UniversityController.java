package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.DTOs.UniversityDTO;
import com.example.UniversityERPSystem.Services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("university")
public class UniversityController {

    UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("add")
    public Long createUniversity(
            @RequestParam String name,
            @RequestParam String location) {

        return universityService.createUniversity(name, location);
    }

    @GetMapping("getAll")
    public List<UniversityDTO> getAllUniversity() {

        return UniversityDTO.convertToDTO(
                universityService.getAllUniversity()
        );
    }

    @GetMapping("getById")
    public UniversityDTO getById(@RequestParam Long id) {

        return UniversityDTO.convertToDTO(
                universityService.getById(id)
        );
    }

    @PutMapping("update")
    public UniversityDTO updateUniversity(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String location) throws Exception {

        return UniversityDTO.convertToDTO(
                universityService.updateUniversity(id, name, location)
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteUniversity(@RequestParam Long id) {

        return universityService.deleteById(id);
    }
}