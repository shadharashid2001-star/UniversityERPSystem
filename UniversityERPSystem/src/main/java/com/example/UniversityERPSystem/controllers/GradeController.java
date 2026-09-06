package com.example.UniversityERPSystem.Controllers;

import com.example.UniversityERPSystem.DTOs.GradeDTO;
import com.example.UniversityERPSystem.Services.GradeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grade")
public class GradeController {

    GradeServices gradeServices;

    @Autowired
    public GradeController(GradeServices gradeServices) {
        this.gradeServices = gradeServices;
    }

    @PostMapping("add")
    public Long createGrade(@RequestParam Integer score,
                            @RequestParam String letterGrade,
                            @RequestParam Long enrollmentId,
                            @RequestParam Long examId) throws Exception {

        return gradeServices.createGrade(
                score,
                letterGrade,
                enrollmentId,
                examId
        );
    }

    @GetMapping("getAll")
    public List<GradeDTO> getAllGrade() {

        return GradeDTO.convertToDTO(
                gradeServices.getAllGrade()
        );
    }

    @GetMapping("getById")
    public GradeDTO getById(@RequestParam Long id) {

        return GradeDTO.convertToDTO(
                gradeServices.getById(id)
        );
    }

    @PutMapping("update")
    public GradeDTO updateGrade(@RequestParam Long id,
                                @RequestParam Integer score,
                                @RequestParam String letterGrade,
                                @RequestParam Long enrollmentId,
                                @RequestParam Long examId) throws Exception {

        return GradeDTO.convertToDTO(
                gradeServices.updateGrade(
                        id,
                        score,
                        letterGrade,
                        enrollmentId,
                        examId
                )
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteGrade(@RequestParam Long id) {

        return gradeServices.deleteById(id);
    }
}