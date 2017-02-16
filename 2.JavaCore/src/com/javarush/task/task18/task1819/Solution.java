package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String f1 = reader.readLine();
        String f2 = reader.readLine();

        FileWriter file2 = new FileWriter(f2);
        FileReader file1 = new FileReader(f1);



    }
}
