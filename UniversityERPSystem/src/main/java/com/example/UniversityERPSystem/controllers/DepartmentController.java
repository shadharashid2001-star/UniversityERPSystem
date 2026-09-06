package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.Entities.Department;
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
    public List<Department> getAllDepartment() {
        return departmentServices.getAllDepartment();
    }

    @GetMapping("getById")
    public Department getById(@RequestParam Long id) {
        return departmentServices.getById(id);
    }

    @PutMapping("update")
    public Department updateDepartment(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String description) throws Exception {

        return departmentServices.updateDepartment(id, name, description);
    }

    @DeleteMapping("delete")
    public Boolean deleteDepartment(@RequestParam Long id) {
        return departmentServices.deleteById(id);
    }
}