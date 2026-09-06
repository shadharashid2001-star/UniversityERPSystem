package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Guardian extends BaseClass{

    private String name;
    private String relationship;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
