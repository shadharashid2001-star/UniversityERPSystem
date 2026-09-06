package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Course;
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
public class CourseDTO {

    private Long id;
    private String title;
    private String courseCode;
    private Integer creditHours;

    private Long programId;
    private String programName;

    private Long instructorId;
    private String instructorName;

    public static CourseDTO convertToDTO(Course course) {

        if (course == null) {
            return null;
        }

        return CourseDTO.builder()
                .id(course.getId())
                .title(course.getTitle())
                .courseCode(course.getCourseCode())
                .creditHours(course.getCreditHours())

                .programId(
                        course.getProgram() != null
                                ? course.getProgram().getId()
                                : null
                )

                .programName(
                        course.getProgram() != null
                                ? course.getProgram().getName()
                                : null
                )

                .instructorId(
                        course.getInstructor() != null
                                ? course.getInstructor().getId()
                                : null
                )

                .instructorName(
                        course.getInstructor() != null
                                ? course.getInstructor().getName()
                                : null
                )

                .build();
    }

    public static List<CourseDTO> convertToDTO(List<Course> courses) {

        List<CourseDTO> dtoList = new ArrayList<>();

        for (Course course : courses) {
            dtoList.add(convertToDTO(course));
        }

        return dtoList;
    }
}