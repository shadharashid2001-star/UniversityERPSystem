package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Faculty;
import com.example.UniversityERPSystem.Repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacultyServices {

    FacultyRepository facultyRepository;

    @Autowired
    public FacultyServices(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Long createFaculty(String name, String description) {

        Faculty faculty = new Faculty();

        faculty.setActive(true);
        faculty.setCreatedDate(new Date());
        faculty.setName(name);
        faculty.setDescription(description);

        faculty = facultyRepository.save(faculty);

        return faculty.getId();
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.getAllFaculty();
    }

    public Faculty getById(Long id) {

        Faculty faculty = facultyRepository.getById(id);

        if (faculty != null) {
            return faculty;
        }

        return null;
    }

    public Faculty updateFaculty(
            Long id,
            String name,
            String description) throws Exception {

        Faculty facultyToUpdate = facultyRepository.getById(id);

        if (facultyToUpdate == null) {
            throw new Exception("Faculty is not found by the id");
        }

        facultyToUpdate.setName(name);
        facultyToUpdate.setDescription(description);
        facultyToUpdate.setUpdatedDate(new Date());

        facultyRepository.save(facultyToUpdate);

        return facultyToUpdate;
    }

    public Boolean deleteById(Long id) {

        Faculty facultyToUpdate = facultyRepository.getById(id);

        if (facultyToUpdate == null) {
            return false;
        }

        facultyToUpdate.setActive(false);
        facultyToUpdate.setUpdatedDate(new Date());

        facultyRepository.save(facultyToUpdate);

        return true;
    }
}