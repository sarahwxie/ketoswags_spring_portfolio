package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import java.util.function.Supplier;


@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Cart {
    @GetMapping("/cart")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String cart(Model model) {
        CartClass Pizza = new CartClass("Pizza", 8, false);
        CartClass Pancakes = new CartClass("Pancakes", 6, false);
        CartClass Burger = new CartClass("Burger", 10, false);
        CartClass Steak = new CartClass("Steak", 4, true);
        CartClass Salad = new CartClass("Salad", 5, false);
        CartClass Ramen = new CartClass("Ramen", 4, true);
        CartClass Hot_Dog = new CartClass("Hot Dog", 3, true);

        List<String> list = new ArrayList<String>();
        list.add(Pizza.info());
        list.add(Pancakes.info());
        list.add(Burger.info());
        list.add(Steak.info());
        list.add(Salad.info());
        list.add(Ramen.info());
        list.add(Hot_Dog.info());
        System.out.println("ArrayList : " + list);

        model.addAttribute("list", list);

        return "cart"; // returns HTML VIEW (greeting)
    }
}