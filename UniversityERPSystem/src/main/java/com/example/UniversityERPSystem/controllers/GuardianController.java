package com.example.UniversityERPSystem.controllers;

import com.example.UniversityERPSystem.DTOs.GuardianDTO;
import com.example.UniversityERPSystem.Services.GuardianServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guardian")
public class GuardianController {

    GuardianServices guardianServices;

    @Autowired
    public GuardianController(GuardianServices guardianServices) {
        this.guardianServices = guardianServices;
    }

    @PostMapping("add")
    public Long createGuardian(
            @RequestParam String name,
            @RequestParam String relationship,
            @RequestParam String phoneNumber,
            @RequestParam Long studentId) throws Exception {

        return guardianServices.createGuardian(
                name,
                relationship,
                phoneNumber,
                studentId
        );
    }

    @GetMapping("getAll")
    public List<GuardianDTO> getAllGuardian() {

        return GuardianDTO.convertToDTO(
                guardianServices.getAllGuardian()
        );
    }

    @GetMapping("getById")
    public GuardianDTO getById(@RequestParam Long id) {

        return GuardianDTO.convertToDTO(
                guardianServices.getById(id)
        );
    }

    @PutMapping("update")
    public GuardianDTO updateGuardian(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String relationship,
            @RequestParam String phoneNumber,
            @RequestParam Long studentId) throws Exception {

        return GuardianDTO.convertToDTO(
                guardianServices.updateGuardian(
                        id,
                        name,
                        relationship,
                        phoneNumber,
                        studentId
                )
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteGuardian(@RequestParam Long id) {
        return guardianServices.deleteById(id);
    }
}