package com.example.sping_portfolio;

import com.example.sping_portfolio.algorithms.PadovanForLoop;
import com.example.sping_portfolio.algorithms.PadovanWhileLoop;
import com.example.sping_portfolio.grayscale.ImageInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

        @GetMapping("/breakfast")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String breakfast() {
            return "recipes/breakfast";
        }

        @GetMapping("/brunch")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String brunch() {
            return "recipes/brunch";
        }

        @GetMapping("/lunch")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String lunch() {
            return "lrecipes/unch";
        }

        @GetMapping("/teatime")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String teatime() {
            return "recipes/teatime";
        }

        @GetMapping("/dinner")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String dinner() {
            return "recipes/dinner";
        }

        @GetMapping("/dessert")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String dessert() {
            return "recipes/dessert";
        }

        @GetMapping("/drinks")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String drinks() {
            return "recipes/drinks";
        }

        @GetMapping("/snacks")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String snacks() {
            return "recipes/snacks";
        }

        @GetMapping("/pastries")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String pastries() {
            return "recipes/pastries";
        }


        @GetMapping("/crystal")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String crystal() {
            return "individual/crystal";
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

            return "individual/ava";

        }

        @GetMapping("/risa")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String risa() {
            return "individual/risa";
        }

        @GetMapping("/sarah")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String sarah() {
            return "individual/sarah";
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

        @GetMapping("/recipes")
        // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
        public String recipes(Model model) {
            String web_server = "http://localhost:8081/";
            List<ImageInfo> lii = new ArrayList<>();

            String file0 = "/images/breakfast.png";
            lii.add(new ImageInfo(file0, web_server + file0, 12));
            lii.get(0).read_image();

            String file1 = "/images/brunch.png";
            lii.add(new ImageInfo(file1, web_server + file1, 12));
            lii.get(1).read_image();

            String file2 = "/images/lunch.png";
            lii.add(new ImageInfo(file2, web_server + file2, 12));
            lii.get(2).read_image();

            String file3 = "/images/snack.png";
            lii.add(new ImageInfo(file3, web_server + file3, 12));
            lii.get(3).read_image();

            String file4 = "/images/teatime.png";
            lii.add(new ImageInfo(file4, web_server + file4, 12));
            lii.get(4).read_image();

            String file5 = "/images/dinner.png";
            lii.add(new ImageInfo(file5, web_server + file5, 12));
            lii.get(5).read_image();

            String file6 = "/images/dessert.png";
            lii.add(new ImageInfo(file6, web_server + file6, 12));
            lii.get(6).read_image();

            String file7 = "/images/drinks.png";
            lii.add(new ImageInfo(file7, web_server + file7, 12));
            lii.get(7).read_image();

            String file8 = "/images/pastries.png";
            lii.add(new ImageInfo(file8, web_server + file8, 12));
            lii.get(8).read_image();

            model.addAttribute("lii", lii);
            return "recipes";
        }

        @GetMapping("/ascii")
        public String ascii(Model model) {
            String web_server = "http://localhost:8081/";
            List<ImageInfo> lii = new ArrayList<>();

            String file0 = "/images/test.png";
            lii.add(new ImageInfo(file0, web_server+file0, 12));
            String[] str = lii.get(0).ascii_toview();

            model.addAttribute("str", str);
            return "ascii";
        }


        @GetMapping("/recipes/grayscale")
        public String recipes_grayscale(Model model) {
            String web_server = "http://localhost:8081/";
            List<ImageInfo> lii = new ArrayList<>();

            String file0 = "/images/breakfast.png";
            lii.add(new ImageInfo(file0, web_server+file0, 12));
            String str = lii.get(0).grayscale();

            String file1 = "/images/brunch.png";
            lii.add(new ImageInfo(file1, web_server+file1, 12));
            String str1 = lii.get(1).grayscale();

            String file2 = "/images/lunch.png";
            lii.add(new ImageInfo(file2, web_server+file2, 12));
            String str2 = lii.get(2).grayscale();

            String file3 = "/images/snack.png";
            lii.add(new ImageInfo(file3, web_server+file3, 12));
            String str3 = lii.get(3).grayscale();

            String file4 = "/images/teatime.png";
            lii.add(new ImageInfo(file4, web_server+file4, 12));
            String str4 = lii.get(4).grayscale();

            String file5 = "/images/dinner.png";
            lii.add(new ImageInfo(file5, web_server+file5, 12));
            String str5 = lii.get(5).grayscale();

            String file6 = "/images/dessert.png";
            lii.add(new ImageInfo(file6, web_server+file6, 12));
            String str6 = lii.get(6).grayscale();

            String file7 = "/images/drinks.png";
            lii.add(new ImageInfo(file7, web_server+file7, 12));
            String str7 = lii.get(7).grayscale();

            String file8 = "/images/pastries.png";
            lii.add(new ImageInfo(file7, web_server+file8, 12));
            String str8 = lii.get(8).grayscale();


            model.addAttribute("str", str);
            model.addAttribute("str1", str1);
            model.addAttribute("str2", str2);
            model.addAttribute("str3", str3);
            model.addAttribute("str4", str4);
            model.addAttribute("str5", str5);
            model.addAttribute("str6", str6);
            model.addAttribute("str7", str7);
            model.addAttribute("str8", str8);
            return "recipes_grayscale";
        }

        @GetMapping("/recipes/winter")
        public String recipes_winter(Model model) {
            String web_server = "http://localhost:8081/";
            List<ImageInfo> lii = new ArrayList<>();

            String file0 = "/images/breakfast.png";
            lii.add(new ImageInfo(file0, web_server+file0, 12));
            String str = lii.get(0).addTextWatermark();

            String file1 = "/images/brunch.png";
            lii.add(new ImageInfo(file1, web_server+file1, 12));
            String str1 = lii.get(1).addTextWatermark();

            String file2 = "/images/lunch.png";
            lii.add(new ImageInfo(file2, web_server+file2, 12));
            String str2 = lii.get(2).addTextWatermark();

            String file3 = "/images/snack.png";
            lii.add(new ImageInfo(file3, web_server+file3, 12));
            String str3 = lii.get(3).addTextWatermark();

            String file4 = "/images/teatime.png";
            lii.add(new ImageInfo(file4, web_server+file4, 12));
            String str4 = lii.get(4).addTextWatermark();

            String file5 = "/images/dinner.png";
            lii.add(new ImageInfo(file5, web_server+file5, 12));
            String str5 = lii.get(5).addTextWatermark();

            String file6 = "/images/dessert.png";
            lii.add(new ImageInfo(file6, web_server+file6, 12));
            String str6 = lii.get(6).addTextWatermark();

            String file7 = "/images/drinks.png";
            lii.add(new ImageInfo(file7, web_server+file7, 12));
            String str7 = lii.get(7).addTextWatermark();

            String file8 = "/images/pastries.png";
            lii.add(new ImageInfo(file7, web_server+file8, 12));
            String str8 = lii.get(8).addTextWatermark();


            model.addAttribute("str", str);
            model.addAttribute("str1", str1);
            model.addAttribute("str2", str2);
            model.addAttribute("str3", str3);
            model.addAttribute("str4", str4);
            model.addAttribute("str5", str5);
            model.addAttribute("str6", str6);
            model.addAttribute("str7", str7);
            model.addAttribute("str8", str8);

            return "recipes_copyright";

        }



        // need to connect to front end with recipes_grayscale.html

    }
}
