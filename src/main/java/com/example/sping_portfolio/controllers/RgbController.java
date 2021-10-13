package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sping_portfolio.controllers.ImageInfo;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RgbController {

    String web_server = "http://localhost:8081/";
    List<ImageInfo> ImageInfoInit(String[] filenames, int[] scalefactors) {
        List<ImageInfo> ret = new ArrayList<>();
        for(int i = 0; i < filenames.length; i++){
            ret.add(new ImageInfo(filenames[i], web_server+filenames[i], scalefactors[i]));
            ret.get(i).read_image();
        }
        return ret;
    }

    @GetMapping("/rgb")
    public String image(Model model)  {
        String[] filenames = {"/images/Mona_lisa.png", "/images/background.png", "/images/bulb_off.png"};
        int[] scalefactors = {12, 15, 7};
        List<ImageInfo> lii = ImageInfoInit(filenames, scalefactors);

        model.addAttribute("lii", lii);
        return "rgb";
    }
}