package com.example.sping_portfolio;

import com.example.sping_portfolio.algorithms.PadovanForLoop;
import com.example.sping_portfolio.grayscale.ImageInfo;
import com.example.sping_portfolio.algorithms.PadovanWhileLoop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                PadovanForLoop p1 = new PadovanForLoop();
                p1.calculatePadovan(n);
                model.addAttribute("forLoop", p1.getResults());

                PadovanWhileLoop p2 = new PadovanWhileLoop();
                p2.calculatePadovan(n);
                model.addAttribute("whileLoop", p2.getResults());
            }
            else {
                model.addAttribute("forLoop", 0);
                model.addAttribute("whileLoop", 0);
            }

            return "ava";

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
        @GetMapping("/image")
        public String image(Model model)  {
            //String web_server = "http://localhost:8080/";
            String web_server = "https://csa.nighthawkcodingsociety.com";
            List<ImageInfo> lii = new ArrayList<>();

            String file0 = "/images/Mona_Lisa.png";
            lii.add(new ImageInfo(file0, web_server+file0, 12));
            lii.get(0).read_image();

            String file1 = "/images/bulb_on.gif";
            lii.add(new ImageInfo(file1, web_server+file1, 2));
            lii.get(1).read_image();

            String file2 = "/images/bulb_off.png";
            lii.add(new ImageInfo(file2, web_server+file2, 7));
            lii.get(2).read_image();

            model.addAttribute("lii", lii);
            return "starters/image";
        }

        @GetMapping("/image/grayscale")
        public String image_grayscale(Model model) {
            //String web_server = "http://localhost:8080/";
            String web_server = "https://csa.nighthawkcodingsociety.com";
            List<ImageInfo> lii = new ArrayList<>();

            String file0 = "/images/Mona_Lisa.png";
            lii.add(new ImageInfo(file0, web_server+file0, 12));
            String str = lii.get(0).grayscale();
//        String str = lii.get(0).grayscale();
            model.addAttribute("str", str);
            return "starters/image_grayscale";
        }

        @GetMapping("/image")
        public String image(Model model) {
            String web_server = "http://localhost:8081/";
            List<ImageInfo> lii = new ArrayList<>();

            String file0 = "/images/drinks.jpg";
            lii.add(new ImageInfo(file0, web_server + file0, 12));
            lii.get(0).read_image();

            String file1 = "/images/dessert.jpg";
            lii.add(new ImageInfo(file1, web_server + file1, 2));
            lii.get(1).read_image();

            String file2 = "/images/teatime.jpg";
            lii.add(new ImageInfo(file2, web_server + file2, 7));
            lii.get(2).read_image();

            model.addAttribute("lii", lii);
            return "image";
        }

        @GetMapping("/image/grayscale")
        public String image_grayscale(Model model) {
            String web_server = "http://localhost:8081/";
            List<ImageInfo> lii = new ArrayList<>();

            String file0 = "/images/bag.png";
            lii.add(new ImageInfo(file0, web_server+file0, 12));
            String str = lii.get(0).grayscale();
//        String str = lii.get(0).grayscale();
            model.addAttribute("str", str);
            return "image_grayscale";
            }

    }
}
