package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Use @RestController to make this class a rest API controller and to convert the response from a Java obj into a JSON obj
@RestController
public class HelloWorldController {

    // HTTP GET Request
    // http://localhost:8080/hello-world

    // @GetMapping: map incoming HTTP GET request to this method
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
}
