package com.example.sping_portfolio.controllers;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TriangleClass {
    private final Color foregroundColor;
    private final Color backgroundColor;
    private Graphics2D graphics2D;
    private final int lineSize;
    public TriangleClass(){
        this.foregroundColor = Color.BLACK;
        this.backgroundColor = Color.WHITE;
        lineSize = 1;
    }
    public TriangleClass(final Color foregroundColor, final Color backgroundColor, final int lineSize){
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.lineSize = lineSize;
    }
    public BufferedImage generate(final int triangleSize, final int recursionLevel){
        BufferedImage bufferedImage = new BufferedImage(triangleSize, triangleSize, BufferedImage.TYPE_INT_RGB);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(backgroundColor);
        graphics2D.fillRect(0, 0, triangleSize, triangleSize);
        graphics2D.setColor(foregroundColor);
        graphics2D.setStroke(new BasicStroke(lineSize));
        int triangleHeight = (int) Math.round(triangleSize * Math.sqrt(3.0d) / 2.0d);
        Point pointA = new Point(0, triangleHeight);
        Point pointB = new Point(triangleSize / 2, 0);
        Point pointC = new Point(triangleSize, triangleHeight);
        drawTriangle(pointA, pointB, pointC, recursionLevel);
        return bufferedImage;
    }
    private void drawTriangle(Point pointA, Point pointB, Point pointC, final int recursionLevel){
        if(recursionLevel == 1){
            Polygon polygon = new Polygon();
            polygon.addPoint(pointA.x, pointA.y);
            polygon.addPoint(pointB.x, pointB.y);
            polygon.addPoint(pointC.x, pointC.y);
            graphics2D.draw(polygon);
            return;
        }
        Point pointAB = middlePoint(pointA, pointB);
        Point pointBC = middlePoint(pointB, pointC);
        Point pointAC = middlePoint(pointA, pointC);
        drawTriangle(pointA, pointAB, pointAC, recursionLevel - 1);
        drawTriangle(pointAB, pointB, pointBC, recursionLevel - 1);
        drawTriangle(pointAC, pointBC, pointC, recursionLevel - 1);
    }
    private Point middlePoint(Point pointA, Point pointB){
        return new Point((pointA.x + pointB.x) / 2, (pointA.y + pointB.y) / 2);
    }
}