package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Exam;
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
public class ExamDTO {

    private Long id;
    private String title;
    private String examDate;
    private Integer totalMarks;

    private Long courseId;
    private String courseTitle;

    public static ExamDTO convertToDTO(Exam exam) {

        if (exam == null) {
            return null;
        }

        String formattedDate = null;

        if (exam.getExamDate() != null) {
            formattedDate = new SimpleDateFormat("yyyy-MM-dd")
                    .format(exam.getExamDate());
        }

        return ExamDTO.builder()
                .id(exam.getId())
                .title(exam.getTitle())
                .examDate(formattedDate)
                .totalMarks(exam.getTotalMarks())
                .courseId(
                        exam.getCourse() != null
                                ? exam.getCourse().getId()
                                : null
                )
                .courseTitle(
                        exam.getCourse() != null
                                ? exam.getCourse().getTitle()
                                : null
                )
                .build();
    }

    public static List<ExamDTO> convertToDTO(List<Exam> exams) {

        List<ExamDTO> dtoList = new ArrayList<>();

        for (Exam exam : exams) {
            dtoList.add(convertToDTO(exam));
        }

        return dtoList;
    }
}