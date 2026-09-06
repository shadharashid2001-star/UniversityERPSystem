package com.example.UniversityERPSystem.controllers;
import com.example.UniversityERPSystem.DTOs.DepartmentDTO;
import com.example.UniversityERPSystem.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    DepartmentServices departmentServices;

    @Autowired
    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @PostMapping("add")
    public Long createDepartment(
            @RequestParam String name,
            @RequestParam String description) {

        return departmentServices.createDepartment(name, description);
    }

    @GetMapping("getAll")
    public List<DepartmentDTO> getAllDepartment() {

        return DepartmentDTO.convertToDTO(
                departmentServices.getAllDepartment()
        );
    }

    @GetMapping("getById")
    public DepartmentDTO getById(@RequestParam Long id) {

        return DepartmentDTO.convertToDTO(
                departmentServices.getById(id)
        );
    }

    @PutMapping("update")
    public DepartmentDTO updateDepartment(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String description) throws Exception {

        return DepartmentDTO.convertToDTO(
                departmentServices.updateDepartment(
                        id,
                        name,
                        description
                )
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteDepartment(@RequestParam Long id) {

        return departmentServices.deleteById(id);
    }
}