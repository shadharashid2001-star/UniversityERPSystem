package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.DTOs.ProgramDTO;
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

        return programServices.createProgram(
                name,
                degreeLevel,
                durationYears
        );
    }

    @GetMapping("getAll")
    public List<ProgramDTO> getAllProgram() {

        return ProgramDTO.convertToDTO(
                programServices.getAllProgram()
        );
    }

    @GetMapping("getById")
    public ProgramDTO getById(@RequestParam Long id) {

        return ProgramDTO.convertToDTO(
                programServices.getById(id)
        );
    }

    @PutMapping("update")
    public ProgramDTO updateProgram(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String degreeLevel,
            @RequestParam Integer durationYears) throws Exception {

        return ProgramDTO.convertToDTO(
                programServices.updateProgram(
                        id,
                        name,
                        degreeLevel,
                        durationYears
                )
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteProgram(@RequestParam Long id) {

        return programServices.deleteById(id);
    }
}