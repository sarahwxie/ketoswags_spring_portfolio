package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class CartClass {
    String recipe;
    int ingredients;
    boolean enoughFood;

    public CartClass(String recipe, int ingredients, boolean enoughFood) {
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.enoughFood = enoughFood;
    }

    public String info() {
        String foodMessage;

        if (enoughFood) foodMessage = " You have enough food to make this! ";
        else foodMessage = " Your fridge is too empty to make this :( ";

        return recipe + ": Needs " + Integer.toString(ingredients) + " ingredients." + foodMessage;
    }
}