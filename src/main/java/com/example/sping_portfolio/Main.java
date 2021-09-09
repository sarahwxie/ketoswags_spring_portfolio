package com.example.sping_portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Controller  // HTTP requests are handled as a controller, using the @Controller annotation
    public class MainController {

        @GetMapping("/aboutus")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String aboutus() {
            return "aboutus"; // returns HTML VIEW (greeting)
        }

        @GetMapping("/binary")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String binary() {
            return "starters/binary";
        }

        @GetMapping("/recipes")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String recipes() {
            return "recipes"; // returns HTML VIEW (greeting)
        }

        @GetMapping("/ava")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String ava() {
            return "ava"; // returns HTML VIEW (greeting)
        }

        @GetMapping("/crystal")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String crystal() {
            return "crystal"; // returns HTML VIEW (greeting)
        }

        @GetMapping("/sarah")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String sarah() {
            return "sarah"; // returns HTML VIEW (greeting)
        }

        @GetMapping("/fortune")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String fortune(@RequestParam(name = "name", required = false, defaultValue = "999") String name, Model model) {
            // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
            model.addAttribute("name", Integer.parseInt(name) + 1);
            return "fortune"; // returns HTML VIEW (greeting)
        }
    }
}


