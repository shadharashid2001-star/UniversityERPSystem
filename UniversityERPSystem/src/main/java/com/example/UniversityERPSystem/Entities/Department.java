package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Department extends BaseClass {

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Program> programs;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Instructor> instructors;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Classroom> classrooms;
}