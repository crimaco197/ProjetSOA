package fr.insa.ms.signUP.controller;

import fr.insa.ms.signUP.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class SignUpServiceController {

    private List<User> users = new ArrayList<>();

    // Method to GET all users (To test if POST is working)
    @GetMapping("/users")
    public List<User> getAllStudents() {
        return users;
    }

    // Method to ADD a user
    @PostMapping("/sign-up")
    public User addNewUser(@RequestBody User user) {
        users.add(user);
        return user;
    }


    // OTHERS METHODS

    // Method GET to find a student by ID
    @GetMapping("/users/{userID}")
    public User getStudentById(@PathVariable String userID) {
        for (User user : users) {
            if (Objects.equals(user.getUserID(), userID)) {
                return user;
            }
        }
        return null; // return null if student is not found
    }

    // Method to UPDATE a student by ID
    @PutMapping("/users/{userID}")
    public User updateStudentById(@PathVariable String userID, @RequestBody User userUpdate) {
        for (User user : users) {
            if (Objects.equals(user.getUserID(), userID)) {
                user.setUserID(userID);
                user.setFirstName(userUpdate.getFirstName());
                user.setLastName(userUpdate.getLastName());
                user.setEmail(userUpdate.getEmail());
                user.setPassword(userUpdate.getPassword());
                user.setUserType(userUpdate.getUserType());
                return user;
            }
        }
        return null; // return null if student is not found
    }

    // Method to DELETE a student by ID
    @DeleteMapping("/users/{userID}")
    public String deleteStudentById(@PathVariable String userID) {
        for (User user : users) {
            if (Objects.equals(user.getUserID(), userID)) {
                users.remove(user);
                return "User " + userID + " has been deleted.";
            }
        }
        return null; // return null if student is not found
    }
}
