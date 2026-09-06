package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.University;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDTO {

    private Long id;
    private String name;
    private String location;

    public static UniversityDTO convertToDTO(University university) {

        if (university == null) {
            return null;
        }

        return UniversityDTO.builder()
                .id(university.getId())
                .name(university.getName())
                .location(university.getLocation())
                .build();
    }

    public static List<UniversityDTO> convertToDTO(List<University> universities) {

        List<UniversityDTO> dtoList = new ArrayList<>();

        for (University university : universities) {
            dtoList.add(convertToDTO(university));
        }

        return dtoList;
    }
}