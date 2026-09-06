package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.University;
import com.example.UniversityERPSystem.Repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UniversityService {

    UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public Long createUniversity(String name, String location) {

        University university = new University();

        university.setActive(true);
        university.setCreatedDate(new Date());
        university.setName(name);
        university.setLocation(location);

        university = universityRepository.save(university);

        return university.getId();
    }

    public List<University> getAllUniversity() {
        return universityRepository.getAllUniversity();
    }

    public University getById(Long id) {

        University university = universityRepository.getById(id);

        if (university != null) {
            return university;
        }

        return null;
    }

    public University updateUniversity(Long id, String name, String location) throws Exception {

        University universityToUpdate = universityRepository.getById(id);

        if (universityToUpdate == null) {
            throw new Exception("University is not found by the id");
        }

        universityToUpdate.setName(name);
        universityToUpdate.setLocation(location);
        universityToUpdate.setUpdatedDate(new Date());

        universityToUpdate = universityRepository.save(universityToUpdate);

        return universityToUpdate;
    }

    public Boolean deleteById(Long id) {

        University universityToUpdate = universityRepository.getById(id);

        if (universityToUpdate == null) {
            return false;
        }

        universityToUpdate.setActive(false);
        universityToUpdate.setUpdatedDate(new Date());

        universityRepository.save(universityToUpdate);

        return true;
    }
}