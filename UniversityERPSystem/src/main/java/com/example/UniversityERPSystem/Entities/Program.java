package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Program extends BaseClass{

    private String name;
    private String degreeLevel;
    private Integer durationYears;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
    private List<Course> courses;
}
