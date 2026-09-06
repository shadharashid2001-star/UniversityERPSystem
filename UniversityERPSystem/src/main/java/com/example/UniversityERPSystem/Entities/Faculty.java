package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Faculty extends BaseClass {

    private String name;
    private String  description;


    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Department> departments;}
