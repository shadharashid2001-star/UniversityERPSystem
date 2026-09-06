package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Guardian;
import com.example.UniversityERPSystem.Entities.Student;
import com.example.UniversityERPSystem.Repositories.GuardianRepository;
import com.example.UniversityERPSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GuardianServices {

    GuardianRepository guardianRepository;
    StudentRepository studentRepository;

    @Autowired
    public GuardianServices(GuardianRepository guardianRepository,
                            StudentRepository studentRepository) {
        this.guardianRepository = guardianRepository;
        this.studentRepository = studentRepository;
    }

    public Long createGuardian(String name,
                               String relationship,
                               String phoneNumber,
                               Long studentId) throws Exception {

        Student student = studentRepository.getById(studentId);

        if (student == null) {
            throw new Exception("Student is not found by the id");
        }

        Guardian guardian = new Guardian();

        guardian.setActive(true);
        guardian.setCreatedDate(new Date());
        guardian.setName(name);
        guardian.setRelationship(relationship);
        guardian.setPhoneNumber(phoneNumber);
        guardian.setStudent(student);

        guardian = guardianRepository.save(guardian);

        return guardian.getId();
    }

    public List<Guardian> getAllGuardian() {
        return guardianRepository.getAllGuardian();
    }

    public Guardian getById(Long id) {
        return guardianRepository.getById(id);
    }

    public Guardian updateGuardian(Long id,
                                   String name,
                                   String relationship,
                                   String phoneNumber,
                                   Long studentId) throws Exception {

        Guardian guardianToUpdate = guardianRepository.getById(id);

        if (guardianToUpdate == null) {
            throw new Exception("Guardian is not found by the id");
        }

        Student student = studentRepository.getById(studentId);

        if (student == null) {
            throw new Exception("Student is not found by the id");
        }

        guardianToUpdate.setName(name);
        guardianToUpdate.setRelationship(relationship);
        guardianToUpdate.setPhoneNumber(phoneNumber);
        guardianToUpdate.setStudent(student);
        guardianToUpdate.setUpdatedDate(new Date());

        return guardianRepository.save(guardianToUpdate);
    }

    public Boolean deleteById(Long id) {

        Guardian guardianToDelete = guardianRepository.getById(id);

        if (guardianToDelete == null) {
            return false;
        }

        guardianToDelete.setActive(false);
        guardianToDelete.setUpdatedDate(new Date());

        guardianRepository.save(guardianToDelete);

        return true;
    }
}