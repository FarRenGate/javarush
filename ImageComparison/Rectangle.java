package com.javarush.test.ImageComparison;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by User on 07/02/17.
 */
public class Rectangle {
    Coordinates top,bottom;

    public Rectangle(Coordinates top, Coordinates bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    void RecalcCoordinates (int xc, int yc) //if the new coordinates should be the top-left or bottom-right
    {
        if (top.x>xc) top.x=xc;
        if (top.y>yc) top.y=yc;
        if (bottom.x<xc) bottom.x=xc;
        if (bottom.y<yc) bottom.y=yc;
    }


    void Draw (BufferedImage img) // draw the rectangle of the given color
    {
        Color color = Color.green;
        for (int i = top.x; i<=bottom.x; i++)
        {
            img.setRGB(i, top.y, color.getRGB());
            img.setRGB(i, bottom.y, color.getRGB());
        }

        for (int i = top.y; i<=bottom.y; i++)
        {img.setRGB(top.x, i, color.getRGB());
            img.setRGB(bottom.x, i, color.getRGB());}
    }

}
