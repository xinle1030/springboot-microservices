package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // Use ResponseEntity to create a response from the API
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students") // configure base url '/students' at controller level using @RequestMapping
public class StudentController {

    // http://localhost:8080/students/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Ramesh",
                "Fadatare");

        // use Student Java bean as a response, and then spring converts Java bean obj
        // to send back to client
        // into JSON obj
        // return new ResponseEntity<>(student, HttpStatus.OK) using .ok(). which returns status code = 200
        // use .header() to return a customized header
        // pass student to body using .body()
        return ResponseEntity.ok()
                .header("custom-header", "ramesh")
                .body(student);
    }

    // return a List in JSON format
    // http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ramesh", "Fadatare"));
        students.add(new Student(2, "umesh", "Fadatare"));
        students.add(new Student(3, "Ram", "Jadhav"));
        students.add(new Student(4, "Sanjay", "Pawar"));

        // pass student list to the response body using .ok()
        return ResponseEntity.ok(students);
    }

    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // @PathVariable is used on a method argument to bind it to the value of a URI
    // template variable
    // http://localhost:8080/students/1/ramesh/fadatare
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
            @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Request Param (for Query ?)
    // @RequestParam is used to extract the value of a query parameters in a request
    // URL
    // http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Fadatare
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
    // @RequestBody: internally uses Spring provided HttpMessageConverter to
    //               retrieve HTTP request body and convert JSON into Java obj
    @PostMapping("create")
    // @ResponseStatus(HttpStatus.CREATED) returns status code 201
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP DELETE Request - deleting the existing
    // resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
