package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.Entities.Program;
import com.example.UniversityERPSystem.Services.ProgramServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("program")
public class ProgramController {

    ProgramServices programServices;

    @Autowired
    public ProgramController(ProgramServices programServices) {
        this.programServices = programServices;
    }

    @PostMapping("add")
    public Long createProgram(
            @RequestParam String name,
            @RequestParam String degreeLevel,
            @RequestParam Integer durationYears) {

        return programServices.createProgram(name, degreeLevel, durationYears);
    }

    @GetMapping("getAll")
    public List<Program> getAllProgram() {

        return programServices.getAllProgram();
    }

    @GetMapping("getById")
    public Program getById(@RequestParam Long id) {

        return programServices.getById(id);
    }

    @PutMapping("update")
    public Program updateProgram(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String degreeLevel,
            @RequestParam Integer durationYears) throws Exception {

        return programServices.updateProgram(
                id,
                name,
                degreeLevel,
                durationYears
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteProgram(@RequestParam Long id) {

        return programServices.deleteById(id);
    }
}