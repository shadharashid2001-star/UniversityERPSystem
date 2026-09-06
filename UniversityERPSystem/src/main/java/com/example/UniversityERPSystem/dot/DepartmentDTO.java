package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Department;
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
public class DepartmentDTO {

    private Long id;
    private String name;
    private String description;

    private Long facultyId;
    private String facultyName;

    public static DepartmentDTO convertToDTO(Department department) {

        if (department == null) {
            return null;
        }

        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .facultyId(
                        department.getFaculty() != null
                                ? department.getFaculty().getId()
                                : null
                )
                .facultyName(
                        department.getFaculty() != null
                                ? department.getFaculty().getName()
                                : null
                )
                .build();
    }

    public static List<DepartmentDTO> convertToDTO(List<Department> departments) {

        List<DepartmentDTO> dtoList = new ArrayList<>();

        for (Department department : departments) {
            dtoList.add(convertToDTO(department));
        }

        return dtoList;
    }
}