package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.*;
import java.util.function.Supplier;


@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class sarah {
    @GetMapping("/sarah")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String triangle(@RequestParam(name = "name", required = false, defaultValue = "10") String name, Model model) {
        TriangleClass myTriangle = new TriangleClass();
        try {
            ImageIO.write(myTriangle.generate(1000, Integer.parseInt(name)), "png", new File("src/main/resources/static/images/triangles/SierpinskiTriangle" + name +".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("name", Integer.parseInt(name));
        return "triangle"; // returns HTML VIEW (greeting)
    }
}