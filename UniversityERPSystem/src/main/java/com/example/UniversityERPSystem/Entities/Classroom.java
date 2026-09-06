package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Classroom extends BaseClass{

    private String roomNumber;
    private Integer  floor;
    private Integer  capacity;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
