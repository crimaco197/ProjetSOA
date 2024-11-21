package fr.insa.ms.StudentsListService.model;

import java.util.ArrayList;
import java.util.List;

public class StudentIDList {

    List<Integer> studentList;

 //   public StudentIDList() {
 //       this.studentList = studentList;
 //   }
    public StudentIDList() {
        this.studentList = new ArrayList<Integer>();
    }

    public List<Integer> getStudentList() {
        return studentList;
    }

    public void addStudentList(Integer studentID) {
        this.studentList.add(studentID);
    }

//    public void setStudentList(Integer studentID) {
//        this.studentList = studentList;
//    }


}
