package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Exam extends BaseClass {

    private String title;

    private Date examDate;

    private Integer totalMarks;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Grade> grades;
}