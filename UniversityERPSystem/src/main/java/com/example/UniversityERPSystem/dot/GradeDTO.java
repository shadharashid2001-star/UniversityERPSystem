package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Grade;
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
public class GradeDTO {

    private Long id;
    private Integer score;
    private String letterGrade;

    private Long enrollmentId;
    private Long examId;
    private String examTitle;

    public static GradeDTO convertToDTO(Grade grade) {

        if (grade == null) {
            return null;
        }

        return GradeDTO.builder()
                .id(grade.getId())
                .score(grade.getScore())
                .letterGrade(grade.getLetterGrade())
                .enrollmentId(
                        grade.getEnrollment() != null
                                ? grade.getEnrollment().getId()
                                : null
                )
                .examId(
                        grade.getExam() != null
                                ? grade.getExam().getId()
                                : null
                )
                .examTitle(
                        grade.getExam() != null
                                ? grade.getExam().getTitle()
                                : null
                )
                .build();
    }

    public static List<GradeDTO> convertToDTO(List<Grade> grades) {

        List<GradeDTO> dtoList = new ArrayList<>();

        for (Grade grade : grades) {
            dtoList.add(convertToDTO(grade));
        }

        return dtoList;
    }
}