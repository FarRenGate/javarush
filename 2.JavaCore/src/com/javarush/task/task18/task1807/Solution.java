package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int buf=0;

        while (inputStream.available()>0) {
            if (inputStream.read()==44) {
                buf++;
            }

        }
        System.out.println(buf);
        reader.close();
        inputStream.close();
    }
}
