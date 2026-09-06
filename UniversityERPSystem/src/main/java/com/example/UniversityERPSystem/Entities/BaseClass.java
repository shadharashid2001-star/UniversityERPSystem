package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean isActive;

    private Date createdDate;

    private Date updatedDate;
}