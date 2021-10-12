package com.example.sping_portfolio.grayscale;

import lombok.Getter;

import java.util.ArrayList;

@Getter  // automatic getter, https://projectlombok.org/features/GetterSetter
public class Binary extends ImageInfo{
    public ArrayList<String> images;
    public int[][][] rgb_matrix;
    public int scale_factor;

    public Binary(String file, String url, int scale_factor) {
        super(file, url, scale_factor);
    }


    public String getBinary(int row, int col) {
        int h = row * this.scale_factor;
        int w = col * this.scale_factor;
        // Java does not have binary as string formatter
        return String.format("%8s", Integer.toBinaryString(rgb_matrix[h][w][0])).replace(' ', '0') +
                " " +
                String.format("%8s", Integer.toBinaryString(rgb_matrix[h][w][1])).replace(' ', '0') +
                " " +
                String.format("%8s", Integer.toBinaryString(rgb_matrix[h][w][2])).replace(' ', '0');
    }

}