package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Program;
import com.example.UniversityERPSystem.Entities.Student;
import com.example.UniversityERPSystem.Repositories.ProgramRepository;
import com.example.UniversityERPSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServices {

    StudentRepository studentRepository;
    ProgramRepository programRepository;

    @Autowired
    public StudentServices(StudentRepository studentRepository,
                           ProgramRepository programRepository) {
        this.studentRepository = studentRepository;
        this.programRepository = programRepository;
    }

    public Long createStudent(String name,
                              String major,
                              String gender,
                              String phoneNumber,
                              Long programId) throws Exception {

        Program program = programRepository.getById(programId);

        if (program == null) {
            throw new Exception("Program is not found by the id");
        }

        Student student = new Student();

        student.setActive(true);
        student.setCreatedDate(new Date());
        student.setName(name);
        student.setMajor(major);
        student.setGender(gender);
        student.setPhoneNumber(phoneNumber);
        student.setProgram(program);

        student = studentRepository.save(student);

        return student.getId();
    }

    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public Student getById(Long id) {
        Student student = studentRepository.getById(id);

        if (student != null) {
            return student;
        }

        return null;
    }

    public Student updateStudent(Long id,
                                 String name,
                                 String major,
                                 String gender,
                                 String phoneNumber,
                                 Long programId) throws Exception {

        Student studentToUpdate = studentRepository.getById(id);

        if (studentToUpdate == null) {
            throw new Exception("Student is not found by the id");
        }

        Program program = programRepository.getById(programId);

        if (program == null) {
            throw new Exception("Program is not found by the id");
        }

        studentToUpdate.setName(name);
        studentToUpdate.setMajor(major);
        studentToUpdate.setGender(gender);
        studentToUpdate.setPhoneNumber(phoneNumber);
        studentToUpdate.setProgram(program);
        studentToUpdate.setUpdatedDate(new Date());

        return studentRepository.save(studentToUpdate);
    }

    public Boolean deleteById(Long id) {

        Student studentToDelete = studentRepository.getById(id);

        if (studentToDelete == null) {
            return false;
        }

        studentToDelete.setActive(false);
        studentToDelete.setUpdatedDate(new Date());

        studentRepository.save(studentToDelete);

        return true;
    }
}