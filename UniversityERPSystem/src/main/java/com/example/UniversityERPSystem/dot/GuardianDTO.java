package com.example.UniversityERPSystem.DTOs;

import com.example.UniversityERPSystem.Entities.Guardian;
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
public class GuardianDTO {

    private Long id;
    private String name;
    private String relationship;

    private Long studentId;
    private String studentName;

    public static GuardianDTO convertToDTO(Guardian guardian) {

        if (guardian == null) {
            return null;
        }

        return GuardianDTO.builder()
                .id(guardian.getId())
                .name(guardian.getName())
                .relationship(guardian.getRelationship())
                .studentId(
                        guardian.getStudent() != null
                                ? guardian.getStudent().getId()
                                : null
                )
                .studentName(
                        guardian.getStudent() != null
                                ? guardian.getStudent().getName()
                                : null
                )
                .build();
    }

    public static List<GuardianDTO> convertToDTO(List<Guardian> guardians) {

        List<GuardianDTO> dtoList = new ArrayList<>();

        for (Guardian guardian : guardians) {
            dtoList.add(convertToDTO(guardian));
        }

        return dtoList;
    }
}