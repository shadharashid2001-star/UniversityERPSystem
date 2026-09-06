package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Student;
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
public class StudentDTO {

    private Long id;
    private String name;
    private String major;
    private String gender;
    private Long programId;
    private String programName;

    public static StudentDTO convertToDTO(Student student) {

        if (student == null) {
            return null;
        }

        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .major(student.getMajor())
                .gender(student.getGender())
                .programId(
                        student.getProgram() != null
                                ? student.getProgram().getId()
                                : null
                )
                .programName(
                        student.getProgram() != null
                                ? student.getProgram().getName()
                                : null
                )
                .build();
    }

    public static List<StudentDTO> convertToDTO(List<Student> students) {

        List<StudentDTO> dtoList = new ArrayList<>();

        for (Student student : students) {
            dtoList.add(convertToDTO(student));
        }

        return dtoList;
    }
}