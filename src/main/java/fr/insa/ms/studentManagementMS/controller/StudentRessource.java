package fr.insa.ms.studentManagementMS.controller;

import fr.insa.ms.studentManagementMS.model.Student;

import org.springframework.web.bind.annotation.*;

// import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentRessource {

    /*

    TUTORIAL

    @GetMapping("students")
    public int studentNumber(){
        return 200;
    }

    @GetMapping(value = "/students{id}")
    public Student infosStudent(@PathVariable int id){
        Student student = new Student(id, "Rosa", "Parks");
        return student;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Student xmlInfosStudent(@PathVariable int id){
        Student student = new Student(id, "Rosa", "Parks");
        return student;
    }
     */

    // EXERCISE PRACTIQUE

    // DataBase to stock the students
    private List<Student> students = new ArrayList<>();

    // Method GET to show all the students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    // Method GET to find a student by ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // return null if student is not found
    }

    // Method to ADD a student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // Method to UPDATE a student by ID
    @PutMapping("/students/{id}")
    public Student updateStudentById(@PathVariable int id, @RequestBody Student studentUpdate) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setId(id);
                student.setFirstName(studentUpdate.getFirstName());
                student.setLastName(studentUpdate.getLastName());
                return student;
            }
        }
        return null; // return null if student is not found
    }

    // Method to DELETE a student by ID
    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return "Student " + id + " has been deleted.";
            }
        }
        return null; // return null if student is not found
    }
}
