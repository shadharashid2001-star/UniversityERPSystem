package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Faculty;
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
public class FacultyDTO {

    private Long id;
    private String name;
    private String description;

    private Long universityId;
    private String universityName;

    public static FacultyDTO convertToDTO(Faculty faculty) {

        if (faculty == null) {
            return null;
        }

        return FacultyDTO.builder()
                .id(faculty.getId())
                .name(faculty.getName())
                .description(faculty.getDescription())
                .universityId(
                        faculty.getUniversity() != null
                                ? faculty.getUniversity().getId()
                                : null
                )
                .universityName(
                        faculty.getUniversity() != null
                                ? faculty.getUniversity().getName()
                                : null
                )
                .build();
    }

    public static List<FacultyDTO> convertToDTO(List<Faculty> faculties) {

        List<FacultyDTO> dtoList = new ArrayList<>();

        for (Faculty faculty : faculties) {
            dtoList.add(convertToDTO(faculty));
        }

        return dtoList;
    }
}