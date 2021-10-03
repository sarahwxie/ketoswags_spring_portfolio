package com.example.sping_portfolio;
import com.example.sping_portfolio.algorithms.Padovan;
import com.example.sping_portfolio.algorithms._Padovan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;

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


        @GetMapping("/crystal")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String crystal() {
            return "crystal";
        }


        @GetMapping("/ava")
        public String ava(@RequestParam(name="padseq", required=false,  defaultValue="0") String padseq, Model model) {
            int n = Integer.parseInt(padseq);
            if (n > 0) {
                Padovan p = new Padovan();
                int result1 = p.calculateWithForLoop(n);
                int result2 = p.calculateWithWhileLoop(n);
                System.out.println(result1);
                System.out.println(result2);
            }
            return "ava";

        }

        @GetMapping("/risa")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String risa() {
            return "risa";
        }
        class expalindrome
        {
            public void main(String args[])
            {
                int x,number, y=0,temp=0;
                Scanner s=new Scanner(System.in);
                System.out.println("Enter any number: ");
                number=s.nextInt();
                x=number;
                while(number>0)
                {
                    x=number%10;
                    number=number/10;
                    temp=temp*10+x;
                }
                if(temp==y)
                {
                    System.out.println("Number is Palindrome");
                }
                else
                {
                    System.out.println("not Palindrome");
                }
            }
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


