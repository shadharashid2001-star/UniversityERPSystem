package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Instructor;
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
public class InstructorDTO {

    private Long id;
    private String name;
    private String email;
    private String specialization;

    private Long departmentId;
    private String departmentName;

    public static InstructorDTO convertToDTO(Instructor instructor) {

        if (instructor == null) {
            return null;
        }

        return InstructorDTO.builder()
                .id(instructor.getId())
                .name(instructor.getName())
                .email(instructor.getEmail())
                .specialization(instructor.getSpecialization())
                .departmentId(
                        instructor.getDepartment() != null
                                ? instructor.getDepartment().getId()
                                : null
                )
                .departmentName(
                        instructor.getDepartment() != null
                                ? instructor.getDepartment().getName()
                                : null
                )
                .build();
    }

    public static List<InstructorDTO> convertToDTO(List<Instructor> instructors) {

        List<InstructorDTO> dtoList = new ArrayList<>();

        for (Instructor instructor : instructors) {
            dtoList.add(convertToDTO(instructor));
        }

        return dtoList;
    }
}