package fr.insa.ms.StudentsListService.controller;

import fr.insa.ms.StudentsListService.model.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentListController {

@GetMapping("ids/{idSpeciality}")
    public StudentIDList getStudentIDs(@PathVariable("idSpeciality") String speciality){

    StudentIDList studentsIDlist = new StudentIDList();
    studentsIDlist.addStudentList(0);
    studentsIDlist.addStudentList(1);
    studentsIDlist.addStudentList(2);

    return studentsIDlist;
    }
}
