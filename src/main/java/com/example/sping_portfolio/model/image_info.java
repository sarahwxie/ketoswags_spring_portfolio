package com.example.sping_portfolio.model;

import lombok.Getter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;

import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import static javax.imageio.ImageIO.read;

@Getter  // this will enable standard Getters on attributes in Class in form "getName" where "name" is attribute
public class image_info {
    // image file
    // list of image property objects
    ArrayList<Long> list;
    String name;
    BufferedImage image;

    public image_info (){
        this.list = list;
        this.image = read(new File(name + ".png"));
    }

}
