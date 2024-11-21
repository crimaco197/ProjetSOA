package fr.insa.ms.OrchestrationService.controller;

import fr.insa.ms.OrchestrationService.model.Evaluation;
import fr.insa.ms.OrchestrationService.model.Student;
// import fr.insa.ms.StudentsListService.model.StudentIDList;


import fr.insa.ms.OrchestrationService.model.StudentIDList;
import fr.insa.ms.OrchestrationService.model.StudentInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

    @Autowired          // permite enlazar el restemplate creado en el main
    private RestTemplate restTemplate;

    @GetMapping("/all/{idSpeciality}")
    public List<Student> getStudents(@PathVariable("idSpeciality") String speciality) {

        // Llamada al StudentListService para obtener la lista de IDs
        // String urlList = "http://localhost:8082/students/ids/" + speciality;  // ADDRESS DEPLOYEMENT
        // StudentsListService = localhost:8082
        String urlList = "http://StudentsListService/students/ids/" + speciality;  // LLAMA A EUREKA
        StudentIDList studentIDList = restTemplate.getForObject(urlList, StudentIDList.class);

        //RestTemplate restTemplate = new RestTemplate();
        int i = 0;
        List<Student> listStudents = new ArrayList<>();

        while (i < studentIDList.getStudentList().size()){

            //Call the MS to get student's information
            //The result is deserialized into StudentInfos java object
            StudentInfos studInfos = restTemplate.getForObject("http://StudentInfoService/student/" + i, StudentInfos.class);
            // StudentInfoService  = http://localhost:8081

            //Call the MS to get student's evaluation
            //The result is deserialized into Evaluation java object
            Evaluation eval = restTemplate.getForObject("http://StudentEvalService/evaluation/" + i, Evaluation.class);
            // StudentEvalService = http://localhost:8083

            //Instanciate a student with his id, first name, last name, average and store it in the list
            listStudents.add(new Student(i, studInfos.getFirstName(), studInfos.getLastName(), eval.getAverage()));
            i++;
        }

        return listStudents;
    }
}
