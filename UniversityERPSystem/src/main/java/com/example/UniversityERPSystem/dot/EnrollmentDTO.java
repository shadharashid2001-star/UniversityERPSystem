package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {

    private Long id;
    private String enrollmentDate;
    private String status;

    private Long studentId;
    private String studentName;

    private Long courseId;
    private String courseTitle;

    public static EnrollmentDTO convertToDTO(Enrollment enrollment) {

        if (enrollment == null) {
            return null;
        }

        String formattedDate = null;

        if (enrollment.getEnrollmentDate() != null) {
            formattedDate = new SimpleDateFormat("yyyy-MM-dd")
                    .format(enrollment.getEnrollmentDate());
        }

        return EnrollmentDTO.builder()
                .id(enrollment.getId())
                .enrollmentDate(formattedDate)
                .status(enrollment.getStatus())
                .studentId(
                        enrollment.getStudent() != null
                                ? enrollment.getStudent().getId()
                                : null
                )
                .studentName(
                        enrollment.getStudent() != null
                                ? enrollment.getStudent().getName()
                                : null
                )
                .courseId(
                        enrollment.getCourse() != null
                                ? enrollment.getCourse().getId()
                                : null
                )
                .courseTitle(
                        enrollment.getCourse() != null
                                ? enrollment.getCourse().getTitle()
                                : null
                )
                .build();
    }

    public static List<EnrollmentDTO> convertToDTO(List<Enrollment> enrollments) {

        List<EnrollmentDTO> dtoList = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            dtoList.add(convertToDTO(enrollment));
        }

        return dtoList;
    }
}