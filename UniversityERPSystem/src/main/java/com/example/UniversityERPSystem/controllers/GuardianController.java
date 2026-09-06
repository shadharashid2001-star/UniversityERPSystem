package com.example.UniversityERPSystem.controllers;

import com.example.UniversityERPSystem.Entities.Guardian;
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
    public Long createGuardian(@RequestParam String name,
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
    public List<Guardian> getAllGuardian() {
        return guardianServices.getAllGuardian();
    }

    @GetMapping("/getById")
    public Guardian getById(@RequestParam Long id) {
        return guardianServices.getById(id);
    }

    @PutMapping("update")
    public Guardian updateGuardian(@RequestParam Long id,
                                   @RequestParam String name,
                                   @RequestParam String relationship,
                                   @RequestParam String phoneNumber,
                                   @RequestParam Long studentId) throws Exception {

        return guardianServices.updateGuardian(
                id,
                name,
                relationship,
                phoneNumber,
                studentId
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteGuardian(@RequestParam Long id) {
        return guardianServices.deleteById(id);
    }
}