package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class University extends BaseClass{

    private String name;
    private String location;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Faculty> faculties;
}
