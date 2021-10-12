package com.example.sping_portfolio.grayscale;

import lombok.Getter;

import java.util.ArrayList;

@Getter  // automatic getter, https://projectlombok.org/features/GetterSetter
public class Hexadecimal extends ImageInfo{
    public ArrayList<String> images;
    public int[][][] rgb_matrix;
    public int scale_factor;

    public Hexadecimal(String file, String url, int scale_factor) {
        super(file, url, scale_factor);
    }


    public String getHexCode(int row, int col) {
        int h = row * this.scale_factor;
        int w = col * this.scale_factor;
        // String.format guarantees 0 padding vs Integer.toHexString
        return "#" +
                String.format("%02X", rgb_matrix[h][w][0]) +
                String.format("%02X", rgb_matrix[h][w][1]) +
                String.format("%02X", rgb_matrix[h][w][2]);
    }

}