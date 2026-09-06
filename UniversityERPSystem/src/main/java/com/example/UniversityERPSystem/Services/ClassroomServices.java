package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Classroom;
import com.example.UniversityERPSystem.Entities.Department;
import com.example.UniversityERPSystem.Repositories.ClassroomRepository;
import com.example.UniversityERPSystem.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClassroomServices {

    ClassroomRepository classroomRepository;
    DepartmentRepository departmentRepository;

    @Autowired
    public ClassroomServices(ClassroomRepository classroomRepository,
                             DepartmentRepository departmentRepository) {
        this.classroomRepository = classroomRepository;
        this.departmentRepository = departmentRepository;
    }

    public Long createClassroom(String roomNumber,
                                Integer floor,
                                Integer capacity,
                                Long departmentId) throws Exception {

        Department department = departmentRepository.getById(departmentId);

        if (department == null) {
            throw new Exception("Department is not found by the id");
        }

        Classroom classroom = new Classroom();

        classroom.setActive(true);
        classroom.setCreatedDate(new Date());
        classroom.setRoomNumber(roomNumber);
        classroom.setFloor(floor);
        classroom.setCapacity(capacity);
        classroom.setDepartment(department);

        classroom = classroomRepository.save(classroom);

        return classroom.getId();
    }

    public List<Classroom> getAllClassroom() {
        return classroomRepository.getAllClassroom();
    }

    public Classroom getById(Long id) {
        return classroomRepository.getById(id);
    }

    public Classroom updateClassroom(Long id,
                                     String roomNumber,
                                     Integer floor,
                                     Integer capacity,
                                     Long departmentId) throws Exception {

        Classroom classroomToUpdate = classroomRepository.getById(id);

        if (classroomToUpdate == null) {
            throw new Exception("Classroom is not found by the id");
        }

        Department department = departmentRepository.getById(departmentId);

        if (department == null) {
            throw new Exception("Department is not found by the id");
        }

        classroomToUpdate.setRoomNumber(roomNumber);
        classroomToUpdate.setFloor(floor);
        classroomToUpdate.setCapacity(capacity);
        classroomToUpdate.setDepartment(department);
        classroomToUpdate.setUpdatedDate(new Date());

        return classroomRepository.save(classroomToUpdate);
    }

    public Boolean deleteById(Long id) {

        Classroom classroomToDelete = classroomRepository.getById(id);

        if (classroomToDelete == null) {
            return false;
        }

        classroomToDelete.setActive(false);
        classroomToDelete.setUpdatedDate(new Date());

        classroomRepository.save(classroomToDelete);

        return true;
    }
}