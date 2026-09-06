package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.Entities.Classroom;
import com.example.UniversityERPSystem.Services.ClassroomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("classroom")
public class ClassroomController {

    ClassroomServices classroomServices;

    @Autowired
    public ClassroomController(ClassroomServices classroomServices) {
        this.classroomServices = classroomServices;
    }

    @PostMapping("add")
    public Long createClassroom(@RequestParam String roomNumber,
                                @RequestParam Integer floor,
                                @RequestParam Integer capacity,
                                @RequestParam Long departmentId) throws Exception {

        return classroomServices.createClassroom(
                roomNumber,
                floor,
                capacity,
                departmentId
        );
    }

    @GetMapping("getAll")
    public List<Classroom> getAllClassroom() {
        return classroomServices.getAllClassroom();
    }

    @GetMapping("getById")
    public Classroom getById(@RequestParam Long id) {
        return classroomServices.getById(id);
    }

    @PutMapping("update")
    public Classroom updateClassroom(@RequestParam Long id,
                                     @RequestParam String roomNumber,
                                     @RequestParam Integer floor,
                                     @RequestParam Integer capacity,
                                     @RequestParam Long departmentId) throws Exception {

        return classroomServices.updateClassroom(
                id,
                roomNumber,
                floor,
                capacity,
                departmentId
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteClassroom(@RequestParam Long id) {
        return classroomServices.deleteById(id);
    }
}