package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Department;
import com.example.UniversityERPSystem.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServices {

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServices(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Long createDepartment(String name, String description) {

        Department department = new Department();

        department.setActive(true);
        department.setCreatedDate(new Date());
        department.setName(name);
        department.setDescription(description);

        department = departmentRepository.save(department);

        return department.getId();
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.getAllDepartment();
    }

    public Department getById(Long id) {

        Department department = departmentRepository.getById(id);

        if (department != null) {
            return department;
        }

        return null;
    }

    public Department updateDepartment(
            Long id,
            String name,
            String description) throws Exception {

        Department departmentToUpdate = departmentRepository.getById(id);

        if (departmentToUpdate == null) {
            throw new Exception("Department is not found by the id");
        }

        departmentToUpdate.setName(name);
        departmentToUpdate.setDescription(description);
        departmentToUpdate.setUpdatedDate(new Date());

        departmentToUpdate = departmentRepository.save(departmentToUpdate);

        return departmentToUpdate;
    }

    public Boolean deleteById(Long id) {

        Department departmentToUpdate = departmentRepository.getById(id);

        if (departmentToUpdate == null) {
            return false;
        }

        departmentToUpdate.setActive(false);
        departmentToUpdate.setUpdatedDate(new Date());

        departmentRepository.save(departmentToUpdate);

        return true;
    }
}