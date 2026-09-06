package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.Entities.University;
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

        return universityService.createUniversity(name,location);
    }

    @GetMapping("getAll")
    public List<University> getAllUniversity() {

        return universityService.getAllUniversity();
    }

    @GetMapping("getById")
    public University getById(@RequestParam Long id) {



        return universityService.getById(id);
    }

    @PutMapping("update")
    public University updateUniversity(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String location) throws Exception {


        return universityService.updateUniversity(id, name, location);
    }

    @DeleteMapping("delete")
    public Boolean deleteUniversity(@RequestParam Long id) {


        return universityService.deleteById(id);
    }
}