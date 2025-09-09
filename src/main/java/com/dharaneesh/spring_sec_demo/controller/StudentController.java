package com.dharaneesh.spring_sec_demo.controller;

import com.dharaneesh.spring_sec_demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    static List<Student> list = new ArrayList<>(List.of(
            new Student(101L, "Iron Man", "tonystark@gmail.com"),
            new Student(102L, "Thor", "thor@gmail.com")
    ));

    @GetMapping("/CSRF")
    public CsrfToken getCSRF(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return list;
    }

    @PostMapping("/add-student")
    public void addStudent(@RequestBody Student student) {
        list.add(student);
    }

}
