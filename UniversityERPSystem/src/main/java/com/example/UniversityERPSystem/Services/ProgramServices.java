package com.example.UniversityERPSystem.Services;

import com.example.UniversityERPSystem.Entities.Program;
import com.example.UniversityERPSystem.Repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProgramServices {

    ProgramRepository programRepository;

    @Autowired
    public ProgramServices(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public Long createProgram(
            String name,
            String degreeLevel,
            Integer durationYears) {

        Program program = new Program();

        program.setActive(true);
        program.setCreatedDate(new Date());
        program.setName(name);
        program.setDegreeLevel(degreeLevel);
        program.setDurationYears(durationYears);

        program = programRepository.save(program);

        return program.getId();
    }

    public List<Program> getAllProgram() {
        return programRepository.getAllProgram();
    }

    public Program getById(Long id) {

        Program program = programRepository.getById(id);

        if (program != null) {
            return program;
        }

        return null;
    }

    public Program updateProgram(
            Long id,
            String name,
            String degreeLevel,
            Integer durationYears) throws Exception {

        Program programToUpdate = programRepository.getById(id);

        if (programToUpdate == null) {
            throw new Exception("Program is not found by the id");
        }

        programToUpdate.setName(name);
        programToUpdate.setDegreeLevel(degreeLevel);
        programToUpdate.setDurationYears(durationYears);
        programToUpdate.setUpdatedDate(new Date());

        programToUpdate = programRepository.save(programToUpdate);

        return programToUpdate;
    }

    public Boolean deleteById(Long id) {

        Program programToUpdate = programRepository.getById(id);

        if (programToUpdate == null) {
            return false;
        }

        programToUpdate.setActive(false);
        programToUpdate.setUpdatedDate(new Date());

        programRepository.save(programToUpdate);

        return true;
    }
}