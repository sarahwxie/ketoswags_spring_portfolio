package com.example.sping_portfolio.grayscale;

import lombok.Getter;

import java.util.ArrayList;

@Getter  // automatic getter, https://projectlombok.org/features/GetterSetter
public class RgbAttributes extends ImageInfo{
    public ArrayList<String> images;

    public RgbAttributes(String file, String url, int scale_factor) {
        super(file, url, scale_factor);
    }


    public String getRGB(int row, int col) {
        int h = row * this.scale_factor;
        int w = col * this.scale_factor;
        return "(" + rgb_matrix[h][w][0] +
                "," + rgb_matrix[h][w][1] +
                "," + rgb_matrix[h][w][2] +
                ")";
    }

}