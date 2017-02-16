package com.javarush.task.task18.task1818;

/* 
Два в одном
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
        String f3 = reader.readLine();

        FileWriter file1 = new FileWriter(f1);
        FileReader file2 = new FileReader(f2);
        FileReader file3 = new FileReader(f3);

        while (file2.ready()) //пока есть непрочитанные байты в потоке ввода
        {

            file1.write(file2.read()); //пишем один символ (int будет обрезан/сужен до char)
        }

        while (file3.ready()) //пока есть непрочитанные байты в потоке ввода
        {

            file1.write(file3.read()); //пишем один символ (int будет обрезан/сужен до char)
        }

        file1.close();
        file2.close();
        file3.close();
        reader.close();

    }
}
