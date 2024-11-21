package fr.insa.ms.StudentInfoService.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ms.StudentInfoService.model.StudentInfos;

@RestController
@RequestMapping("/student")
public class StudentInfoResource {

    @GetMapping("/{idStudent}")
    public StudentInfos getInfoStudent(@PathVariable("idStudent") int id){
        // Simulate the BD with a list

        List<StudentInfos> studInfos = Arrays.asList(

        new StudentInfos(0, "Godart", "Noemi", "12/12/1992"),
        new StudentInfos(1, "Andres", "Lale", "12/12/1992"),
                new StudentInfos(2, "Pepe", "Takoto", "12/12/1992")
        );

        // Get the student that corresponds to the id
        return studInfos.get(id);
    }
}
