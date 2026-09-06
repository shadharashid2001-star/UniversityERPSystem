package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Classroom;
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
public class ClassroomDTO {

    private Long id;
    private String roomNumber;
    private Integer floor;
    private Integer capacity;

    private Long departmentId;
    private String departmentName;

    public static ClassroomDTO convertToDTO(Classroom classroom) {

        if (classroom == null) {
            return null;
        }

        return ClassroomDTO.builder()
                .id(classroom.getId())
                .roomNumber(classroom.getRoomNumber())
                .floor(classroom.getFloor())
                .capacity(classroom.getCapacity())
                .departmentId(
                        classroom.getDepartment() != null
                                ? classroom.getDepartment().getId()
                                : null
                )
                .departmentName(
                        classroom.getDepartment() != null
                                ? classroom.getDepartment().getName()
                                : null
                )
                .build();
    }

    public static List<ClassroomDTO> convertToDTO(List<Classroom> classrooms) {

        List<ClassroomDTO> dtoList = new ArrayList<>();

        for (Classroom classroom : classrooms) {
            dtoList.add(convertToDTO(classroom));
        }

        return dtoList;
    }
}