package com.example.UniversityERPSystem.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@MappedSuperclass
public class BaseClass {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private boolean isActive;
    private Date  createdDate;
    private Date  updatedDate;


}
