package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Department;
import com.example.UniversityERPSystem.Entities.Instructor;
import com.example.UniversityERPSystem.Repositories.DepartmentRepository;
import com.example.UniversityERPSystem.Repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorServices {

    InstructorRepository instructorRepository;
    DepartmentServices departmentServices;
    DepartmentRepository departmentRepository;
@Autowired
    public InstructorServices(InstructorRepository instructorRepository, DepartmentServices departmentServices, DepartmentRepository departmentRepository) {
        this.instructorRepository = instructorRepository;
        this.departmentServices = departmentServices;
        this.departmentRepository = departmentRepository;
    }

    public Long createInstructor(
            String name,
            String email,
            String phoneNumber,
            String specialization,Long depId) {
       Department department = departmentServices.getById(depId);
        if (department== null) {
            return -1l;
        }
        Instructor instructor = new Instructor();

        instructor.setActive(true);
        instructor.setCreatedDate(new Date());
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setPhoneNumber(phoneNumber);
        instructor.setSpecialization(specialization);


      Instructor  saveInstructor = instructorRepository.save(instructor);

        List<Instructor> instructors = department.getInstructors();
        instructors.add(saveInstructor);
        department.setInstructors(instructors);
        departmentRepository.save(department);

        return instructor.getId();
    }

    public List<Instructor> getAllInstructor() {
        return instructorRepository.getAllInstructor();
    }

    public Instructor getById(Long id) {

        Instructor instructor = instructorRepository.getById(id);

        if (instructor != null) {
            return instructor;
        }

        return null;
    }

    public Instructor updateInstructor(
            Long id,
            String name,
            String email,
            String phoneNumber,
            String specialization) throws Exception {

        Instructor instructorToUpdate =
                instructorRepository.getById(id);

        if (instructorToUpdate == null) {
            throw new Exception("Instructor is not found by the id");
        }

        instructorToUpdate.setName(name);
        instructorToUpdate.setEmail(email);
        instructorToUpdate.setPhoneNumber(phoneNumber);
        instructorToUpdate.setSpecialization(specialization);
        instructorToUpdate.setUpdatedDate(new Date());

        instructorToUpdate =
                instructorRepository.save(instructorToUpdate);

        return instructorToUpdate;
    }

    public Boolean deleteById(Long id) {

        Instructor instructorToUpdate =
                instructorRepository.getById(id);

        if (instructorToUpdate == null) {
            return false;
        }

        instructorToUpdate.setActive(false);
        instructorToUpdate.setUpdatedDate(new Date());

        instructorRepository.save(instructorToUpdate);

        return true;
    }
}