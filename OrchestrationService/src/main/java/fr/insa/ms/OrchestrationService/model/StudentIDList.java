package fr.insa.ms.OrchestrationService.model;

import java.util.ArrayList;
import java.util.List;

public class StudentIDList {
    List <Integer> studentList;

    public StudentIDList() {
        this.studentList = new ArrayList<Integer>();
    }

    public List<Integer> getStudentList() {
        return studentList;
    }

    public void addStudentList(Integer studentId) {
        this.studentList.add(studentId);
    }
}
