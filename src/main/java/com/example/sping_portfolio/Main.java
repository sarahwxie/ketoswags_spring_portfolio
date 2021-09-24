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
            return "aboutus";
        }

        @GetMapping("/imagetest")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String imagetest() {
            return "imagetest";
        }

        @GetMapping("/algorithm")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String algorithm() {
            return "algorithm";
        }

        @GetMapping("/binary")
        public String binary(@RequestParam(name = "bits", required = false, defaultValue = "8") int bits, Model model) {// CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
            model.addAttribute("bits",bits);
            return "binary";
        }

        @GetMapping("/recipes")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String recipes() {
            return "recipes";
        }

        @GetMapping("/breakfast")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String breakfast() {
            return "breakfast";
        }

        @GetMapping("/brunch")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String brunch() {
            return "brunch";
        }

        @GetMapping("/lunch")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String lunch() {
            return "lunch";
        }

        @GetMapping("/teatime")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String teatime() {
            return "teatime";
        }

        @GetMapping("/dinner")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String dinner() {
            return "dinner";
        }

        @GetMapping("/dessert")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String dessert() {
            return "dessert";
        }

        @GetMapping("/drinks")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String drinks() {
            return "drinks";
        }

        @GetMapping("/snacks")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String snacks() {
            return "snacks";
        }

        @GetMapping("/pastries")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String pastries() {
            return "pastries";
        }

        @GetMapping("/ava")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String ava() {
            return "ava";
        }

        @GetMapping("/crystal")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String crystal() {
            return "crystal";
        }

        @GetMapping("/risa")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String risa() {
            return "risa";
        }

        @GetMapping("/sarah")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String sarah() {
            return "sarah";
        }

        @GetMapping("/babyback")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String babyback() {
            return "babyback";
        }

        @GetMapping("/login")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String login() {
            return "login";
        }

        @GetMapping("/fortune")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String fortune(@RequestParam(name = "name", required = false, defaultValue = "999") String name, Model model) {
            // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
            model.addAttribute("name", Integer.parseInt(name) + 1);
            return "fortune";
        }

    }
}


