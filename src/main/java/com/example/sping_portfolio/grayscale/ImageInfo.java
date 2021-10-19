package com.example.sping_portfolio.grayscale;

import com.example.sping_portfolio.Main;
import lombok.Getter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.SpringApplication;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

@Getter  // automatic getter, https://projectlombok.org/features/GetterSetter
public class ImageInfo {
    public int scale_factor;
    public String file, url;
    public int height, scaled_height;
    public int width, scaled_width;
    public int[][][] rgb_matrix;

    // basic constructor
    public ImageInfo(String file, String url, int scale_factor) {
        this.file = file;
        this.url = url;
        this.scale_factor = scale_factor;
    }

    // sets for properties of the image, including pixels and colors
    // ORIGINAL INFO
    public Exception read_image() {
        try {
            BufferedImage img = ImageIO.read(new URL(this.url));
            this.height = img.getHeight();
            this.scaled_height = this.height / scale_factor;
            this.width = img.getWidth();
            this.scaled_width = this.width / scale_factor;
            //System.out.println(Integer.toString(this.height) + " " + Integer.toString(this.width));
            this.rgb_matrix = new int[this.height][this.width][3];

            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {
                    int pixel = img.getRGB(x, y);
                    Color color = new Color(pixel, true);

                    this.rgb_matrix[y][x][0] = color.getRed();
                    this.rgb_matrix[y][x][1] = color.getGreen();
                    this.rgb_matrix[y][x][2] = color.getBlue();
                }
            }
            // System.out.println(this.rgb_matrix);

        } catch (Exception e) {
            return e;
        }

        return null;
    }

    // grayscale method
    // return: base64 in grayscale
    // GREY
    public String grayscale() {
        try {
            BufferedImage img = ImageIO.read(new URL(url)); // Saving internet image to BufferedImage
            byte[] pixels = image_to_pixels(img); // See method definition
            int[] pixels_int = grayscale(pixels);
            // System.out.println("here's the pixels");
            // System.out.println(pixels_int);
            String base64 = pixels_to_base64(img.getWidth(), img.getHeight(), pixels_int);
            // System.out.println("here's the base 64" + base64);
            // System.out.println("data:image/jpg;base64," + base64);
            return "data:image/jpg;base64," + base64;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    // sarah+crystal's dope ascii converter
    public String[] ascii_toview() {
        try {
            BufferedImage img = ImageIO.read(new URL(url)); // Saving internet image to BufferedImage
            byte[] pixels = image_to_pixels(img); // See method definition
            System.out.println("here it is but before");
            int[] pixels_int = grayscale(pixels);
            String[] pixels_string = ascii_conversion(pixels_int);
            int count = 0;
            for (int i = 0; i < img.getHeight(); i++)
            {
                for (int j = 0; j < img.getWidth(); j++)
                {
                    System.out.print(pixels_string[count]);
                    count ++;
                }
                System.out.println();

            }
            // System.out.println(Arrays.toString(pixels_string));
            /*
            String result = String.join("", pixels_string);

            String[] toView = new String[img.getHeight()];
            for (int i = 0; i < img.getHeight(); i++){
                String row = "";
                for (int j = 0; i < img.getWidth(); j++) {
                    row = row + result.charAt(img.getWidth() * i + j);
                }
                toView[i] = row;
                System.out.println(row);
            }*/
            // System.out.println(pixels_string);
            // System.out.println("here's the base 64" + base64);
            String[] toView = new String[0];
            return toView;
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] toView = new String[0];
        return toView;
    }


    // given an image, creates a watermark
    public String addTextWatermark() {
        try {
            BufferedImage sourceImage = ImageIO.read(new URL(this.url));
            Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

            // initializes necessary graphic properties
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
            g2d.setComposite(alphaChannel);
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 80));
            FontMetrics fontMetrics = g2d.getFontMetrics();
            Rectangle2D rect = fontMetrics.getStringBounds("Fridge", g2d);

            // calculates the coordinate where the String is painted
            int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
            int centerY = sourceImage.getHeight() / 2;

            // paints the textual watermark
            g2d.drawString("Fridge", centerX, centerY);

            ImageIO.write(sourceImage, "png", new File("sarahUniqueFile.png"));
            g2d.dispose();

            System.out.println("The tex watermark is added to the image.");
            byte[] pixels = image_to_pixels(sourceImage); // See method definition
            int[] pixels_int = normal(pixels);
            String base64 = pixels_to_base64(sourceImage.getWidth(), sourceImage.getHeight(), pixels_int);
            return "data:image/jpg;base64," + base64;

        } catch (IOException ex) {
            System.err.println(ex);
        }
        return "";
    }

    /**
     * base64 conversion, support PNG only
     * We will iterate through the 1D pixel array and set the rgb values to corresponding locations on image
     * Then Base64 encode
     */
    public String pixels_to_base64(int width, int height, int[] pixels) throws IOException {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int a, r, g, b;
                int s = (y * width + x) * 4;
                a = pixels[s];
                r = pixels[s + 1];
                g = pixels[s + 2];
                b = pixels[s + 3];
                img.setRGB(x, y, argb(a, r, g, b));
            }
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", bos);
        byte[] data = bos.toByteArray();
        return Base64.encodeBase64String(data);
    }

    /**
     * Converts the colored pixel array to 1D INT array of grayscale values
     * Grayscale is simple all rgb values set to the same value, (0,0,0) (100,100,100) (255, 255, 255)
     * Look through the byte values and take the average of the RGB values and set them all equal to that same average
     * Ignore the alpha, it controls transparency
     */
    public int[] grayscale(byte[] pixels) {
        int[] pixels_int = new int[pixels.length];
        for (int i = 0; i < pixels.length; i += 4) {
            float val = 0;
            for (int y = 1; y < 4; y++) {
                val += (pixels[i + y] & 0xFF) / 3.0; // The & 0xFF is a "bitwise and" https://www.geeksforgeeks.org/bitwise-operators-in-java/. Just divigin by 3 to get the average
            }
            // System.out.println("here's a val");
            // System.out.println(val);
            pixels_int[i] = pixels[i]; // keep alpha the same
            pixels_int[i + 1] = (int) val;
            pixels_int[i + 2] = (int) val;
            pixels_int[i + 3] = (int) val;
        }
        return pixels_int;
    }

    // the ascii conversion continued
    public String[] ascii_conversion(int[] pixels) {
        String[] ascii_list = new String[pixels.length / 4];
        int count = 0;
        for (int i = 1; i < pixels.length; i += 4) {
            float val = pixels[i];
            if ((int)val > 225){
                ascii_list[count] = "@";
            }
            else if ((int)val > 200){
                ascii_list[count] = "#";
            }
            else if ((int)val > 175){
                ascii_list[count] = "%";
            }
            else if ((int)val > 150){
                ascii_list[count] = "x";
            }
            else if ((int)val > 125){
                ascii_list[count] = "o";
            }
            else if ((int)val > 100){
                ascii_list[count] = ";";
            }
            else if ((int)val > 75){
                ascii_list[count] = ":";
            }
            else if ((int)val > 50){
                ascii_list[count] = ",";
            }
            else if ((int)val > 25){
                ascii_list[count] = ".";
            }
            else {
                ascii_list[count] = " ";
            }
            // System.out.print(ascii_list[count]);
            count ++;
            if (count > 256885) {
                break;
            }
        }
        // System.out.println(ascii_list);
        return ascii_list;
    }

    public int[] normal(byte[] pixels) {
        int[] pixels_int = new int[pixels.length];
        for (int i = 0; i < pixels.length; i += 4) {
            pixels_int[i] = pixels[i]; // keep alpha the same
            pixels_int[i + 1] = pixels[i + 1];
            pixels_int[i + 2] = pixels[i + 2];
            pixels_int[i + 3] = pixels[i + 3];
        }
        // System.out.println(pixels_int);
        return pixels_int;
    }

    /**
     * param img
     * returns byte[]
     * <p>
     * This method takes the buffered image and converts to a 1D array of byte values.
     * If the image is 100 by 300 pixels the length of array will be":
     * 100 x 300 x 4 = 120,000
     * <p>
     * We multiply the total number of pixels by 4 because of ARGB (alpga, red, green, blue)
     */
    public byte[] image_to_pixels(BufferedImage img) throws IOException {
        return ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
    }


    /**
     * building ARGB data
     * An int is 4 bytes
     * Alpha in byte 4, red in byte 3, green in byte 2, blue in byte 1
     */
    public int argb(int a, int r, int g, int b) {
        return ((a & 0x0ff) << 24) | ((r & 0x0ff) << 16) | ((g & 0x0ff) << 8) | (b & 0x0ff);
    }


    public int getScaled_height(int row) {
        return row * this.scale_factor;
    }

    public int getScaled_width(int col) {
        return col * this.scale_factor;
    }


    public String[] convert_to_ascii() {
        int[][] gs = this.to_grayscale();
        int[][] scaled_gs = this.scale(gs);
        //return  this.to_ascii_array(scaled_gs);
        return new String[1];
    }

    public int[][] to_grayscale() {
        // grey scale is calculated to average of pixel
        int[][] gs = new int[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                int r = this.rgb_matrix[h][w][0];
                int g = this.rgb_matrix[h][w][1];
                int b = this.rgb_matrix[h][w][2];
                // averaging
                int avg = (r + g + b) / 3;
                gs[h][w] = avg;
            }
        }
        return gs;
    }

    public int[][] scale(int[][] gs) {
        // scale image down by scale_factor
        int w_scaled = width / scale_factor;
        int h_scaled = height / scale_factor;

        int[][] scaled = new int[h_scaled][w_scaled];
        for (int w = 0; w < w_scaled; w++) {
            for (int h = 0; h < h_scaled; h++) { //looping over blocks

                int sum = 0;
                for (int x = (w) * scale_factor; x < (w + 1) * scale_factor; x++) { //looping over the induvidual coordinates in block
                    for (int y = (h) * scale_factor; y < (h + 1) * scale_factor; y++) {
                        //System.out.println("("+Integer.toString(x)+", "+Integer.toString(y)+")");
                        sum = sum + gs[y][x];
                    }
                } //end loop 2

                scaled[h][w] = sum / (scale_factor * scale_factor);

            }
        } //end loop 1
        //System.out.println(Arrays.deepToString(scaled));
        return scaled;
    }

}