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
public class ListOfImagesInfo extends ImageInfo{
    public ArrayList<String> images;

    // this one is a list of images
    public ListOfImagesInfo(String file, String url, int scale_factor, ArrayList<String> images) {
        super(file, url, scale_factor);
        this.images = images;
    }

    public String[] parseList(){
        String[] array = images.toArray(new String[0]);
        for (String s : array) {
            System.out.println(s);
        }
        return array;
    }

}