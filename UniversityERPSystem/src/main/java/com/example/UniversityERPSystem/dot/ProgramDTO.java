package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Program;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDTO {

    private Long id;
    private String name;
    private String degreeLevel;
    private Integer durationYears;

    private Long departmentId;
    private String departmentName;

    public static ProgramDTO convertToDTO(Program program) {

        if (program == null) {
            return null;
        }

        return ProgramDTO.builder()
                .id(program.getId())
                .name(program.getName())
                .degreeLevel(program.getDegreeLevel())
                .durationYears(program.getDurationYears())
                .departmentId(
                        program.getDepartment() != null
                                ? program.getDepartment().getId()
                                : null
                )
                .departmentName(
                        program.getDepartment() != null
                                ? program.getDepartment().getName()
                                : null
                )
                .build();
    }

    public static List<ProgramDTO> convertToDTO(List<Program> programs) {

        List<ProgramDTO> dtoList = new ArrayList<>();

        for (Program program : programs) {
            dtoList.add(convertToDTO(program));
        }

        return dtoList;
    }
}