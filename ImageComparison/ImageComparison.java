package com.javarush.test.ImageComparison;

/**
 * Created by User on 06/02/17.
 */
import javax.imageio.*;
import java.awt.*;
import  java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;


public class ImageComparison {
    public static void main(String[] args) throws Exception {

        Frame.setSize(2); //distance for the separated pixels to be considered as belonging to one shape

        String image1 = "C:/image1.png";
        String image2 = "C:/image2.png";
        String imageResult = "C:/imageResult.png";
        BufferedImage img1 = null;
        BufferedImage img2 = null;

        TreeMap<Integer,TreeSet<Integer>> pixels = new TreeMap<>(); // here we will store the difference

        try {
            img1 = ImageIO.read(new File(image1));
            img2 = ImageIO.read(new File(image2));
        } catch (IOException e) {
        }


        pixels = CompareImages(img1,img2); // creating the map with difference
        ArrayList<Rectangle> result = FindAreas(pixels); // find the differences and record the coordinates of rectangles
        for (Rectangle r : result) // draw all rectangles
        {
            r.Draw(img2);
        }
        ImageIO.write(img2, "png", new File(imageResult) ); // save image

    }


    public static TreeMap<Integer,TreeSet<Integer>> CompareImages ( BufferedImage img1, BufferedImage img2) // comparing the images
    {
        TreeMap<Integer,TreeSet<Integer>> result = new TreeMap<>();
        Color c1 = null;
        Color c2 = null;

        if (img1.getHeight()!=img2.getHeight()||img1.getWidth()!=img2.getWidth()) return null;

            for (int x=0; x<img1.getWidth(); x++)  // for all pixels comparing the colors, if different - put into the result map
                for (int y=0; y<img1.getHeight(); y++) {
                c1 = new Color(img1.getRGB(x,y));
                c2 = new Color(img2.getRGB(x,y));
                    if (!AreClose(c1,c2)) {
                        if (result.get(x)==null) {
                            result.put(x, new TreeSet<Integer>());
                        }
                        result.get(x).add(y);

                    }
                }



        return result;
    }

         public static boolean AreClose (Color c1, Color c2)
        {
            double coord = Math.sqrt((c1.getRed()-c2.getRed())*(c1.getRed()-c2.getRed())-
                    (c1.getGreen()-c2.getGreen())*(c1.getGreen()-c2.getGreen())-
                    (c1.getBlue()-c2.getBlue())*(c1.getBlue()-c2.getBlue())            ); //distance in the color-space
            double p= coord/Math.sqrt(255*255+255*255+255*255); // percentage of total possible length

            if (p<0.1) return true; // if difference <10% - pixels are same
            return false;
        }


    public static void FindContour (TreeMap<Integer,TreeSet<Integer>> map, int x, int y, Rectangle result) // finding contour to which (x,y) belongs
    {
        if (ImageComparison.Exists(map,x,y))
        {
            Frame frame = new Frame(map,x,y,result); // see the frame class, the output is basically a square with marked neighboring pixels. Note that is also checks the area borders (Rectangle result)
            if (!frame.isEmpty()) // if some neighbors are found
            {
                //System.out.println(map);
               // System.out.println(x+", "+y);
                ArrayList<Coordinates> coordinates = frame.getCoordinates(); // coordinates of the neighbors
                for (int i = 0; i<frame.Neighbors(); i++)
                    FindContour(map, coordinates.get(i).x, coordinates.get(i).y, result); // do the same for each neighbor
            }
        }

    }


    public static ArrayList<Rectangle> FindAreas (TreeMap<Integer,TreeSet<Integer>> map) // find ALL areas
    {
        ArrayList<Rectangle> resultArray = new ArrayList<>();
        while (!map.isEmpty()) {
            Rectangle result = new Rectangle(new Coordinates(map.firstKey(), map.get(map.firstKey()).first()), new Coordinates(map.firstKey(), map.get(map.firstKey()).first())); //creates the output rectangle wiht coordinates in the starting point
            FindContour(map, map.firstKey(), map.get(map.firstKey()).first(),result);// starting from the top pixel of the left line
            resultArray.add(result); // add resulted rectangle to the array
        }
        return resultArray;
    }

    public static boolean Exists (TreeMap<Integer,TreeSet<Integer>> map, int x, int y) //check if the (x,y) pixel is in the map
    {
        if (map.containsKey(x))
            if (map.get(x).contains(y))
                return true;
        return false;
    }

    public static void Remove (TreeMap<Integer,TreeSet<Integer>> map, int x, int y) // removes the (x,y) pixel from the map
    {
        if (Exists(map, x, y))
        {
            map.get(x).remove(y);
            if (map.get(x).isEmpty()) map.remove(x);
        }
    }

}
