package fr.insa.ms.StudentEvalService.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ms.StudentEvalService.model.Evaluation;

@RestController
@RequestMapping("/evaluation")
public class StudentEvaResouce {

    @GetMapping("/{idStudent}")
    public Evaluation getStudentEval(@PathVariable("idStudent") int idStud){

        List<Evaluation> evalList = Arrays.asList(
                new Evaluation(0, 13F),
                new Evaluation(1, 18F),
                new Evaluation(12, 20F)
        );
        return evalList.get(idStud);
    }
}
