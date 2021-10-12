package com.example.sping_portfolio.grayscale;

import lombok.Getter;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@Getter  // automatic getter, https://projectlombok.org/features/GetterSetter
public class ImageProperty extends ImageInfo{
    public String description;
    public ArrayList<String> rgb_attributes;

    // an image_property object (iprop) has-a description, has-a base64 rendering file, has-a list of RGB attributes
    public ImageProperty(String file, String url, int scale_factor, String description, ArrayList<String> rgb_attributes) {
        super(file, url, scale_factor);
        this.description = description;
        this.rgb_attributes = rgb_attributes;
    }

    public String[] getImageProperty(){
        String[] imageProperties = {this.description, String.valueOf(this.rgb_attributes)};
        return imageProperties;
    }

    public String grayscale() {
        try {
            BufferedImage img = ImageIO.read(new URL(url)); // Saving internet image to BufferedImage
            byte[] pixels = image_to_pixels(img); // See method definition
            int[] pixels_int = grayscale(pixels);
            String base64 = pixels_to_base64(img.getWidth(), img.getHeight(), pixels_int);
            return "data:image/jpg;base64," + base64;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}