package com.javarush.test.ImageComparison;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by User on 07/02/17.
 */
public class Frame { // pretty much all processing is done in the constructor

    boolean[][] fill; // map of neighboring pixels (true - pixel is there)
    private static int size = 1; // dimensions of the Frame. Generally, the Frame is (2*size+1)x(2*size+1), with the starting point in the center
    private int xc, yc;


    public static void setSize(int size) {
        Frame.size = size;
    }

    public Frame(TreeMap<Integer, TreeSet<Integer>> map, int xc, int yc, Rectangle rectangle) {
        this.xc = xc;
        this.yc = yc;
        rectangle.RecalcCoordinates(xc,yc); //check if the new coordinates should determine the rectangle which marks the area

        fill = new boolean[2 * size + 1][2 * size + 1];
        for (int x = xc - size; x <= xc + size; x++) //scanning the area around the central pixel
            for (int y = yc - size; y <= yc + size; y++) {
                if (ImageComparison.Exists(map, x, y)) { // if the pixel is found...
                    fill[CoordinateToIndex(x, xc)][CoordinateToIndex(y, yc)] = true; //...mark it in the pixel map
                }
            }
        fill[RelativeCoordinateToIndex(0)][RelativeCoordinateToIndex(0)] = false; //removing the central pixel from the pixel map
        ImageComparison.Remove(map, xc, yc); // removing the central pixel from the map of difference - it is processed already, so we don't need it anymore

    }

    public boolean isEmpty() {
        if (this.Neigbors() == 0) return true;
        return false;
    }

    public int Neigbors() { //calculating number of neighbors (true values in the pixel map)
        int Neighbors = 0;
        for (int i = 0; i < 2 * size + 1; i++)
            for (int j = 0; j < 2 * size + 1; j++) {
                if (fill[i][j]) Neighbors++;
            }
        return Neighbors;
    }

    public ArrayList<Coordinates> getCoordinates() { // getting the coordinates of the neighbors
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        for (int i = -size; i <= size; i++)
            for (int j = -size; j <= size; j++) {
                if (fill[RelativeCoordinateToIndex(i)][RelativeCoordinateToIndex(j)])
                    coordinates.add(new Coordinates(xc + i, yc + j));
            }

        return coordinates;
    }

    private int CoordinateToIndex(int x, int xc) {
        return x - xc + size;
    }


    private int RelativeCoordinateToIndex(int x) {
        return x + size;
    } // relative coordinate assuming the central point is (0,0)

}
