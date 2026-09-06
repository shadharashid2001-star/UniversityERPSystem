package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Grade extends BaseClass {

    private Integer score;

    private String letterGrade;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
}