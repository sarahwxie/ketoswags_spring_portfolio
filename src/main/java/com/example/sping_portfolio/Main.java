package com.example.sping_portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
class Aboutus {
    @GetMapping("/aboutus")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String aboutus() {
        return "aboutus"; // returns HTML VIEW (greeting)
    }
}

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
class Recipes {
    @GetMapping("/recipes")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String recipes() {
        return "recipes"; // returns HTML VIEW (greeting)
    }
}

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
class ava {
    @GetMapping("/ava")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String ava() {
        return "ava"; // returns HTML VIEW (greeting)
    }
}