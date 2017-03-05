package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());

       int count=0;
        String fileContent = "";

        while (fileReader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            fileContent = fileContent + (char)fileReader.read();

            //читаем один символ (char будет расширен до int)
        }

        String[] fileContentArray = fileContent.split("\\W");

        for (String s: fileContentArray)
        {
            if (s.equals("world")) {
                count++;
            }
        }
        System.out.println(count);
        reader.close();
        fileReader.close();
    }
}
