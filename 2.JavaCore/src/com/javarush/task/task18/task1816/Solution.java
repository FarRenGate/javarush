package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        char[] alphabet = {'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        String fileText="";
        String aString = new String(alphabet);
        int number=0;

        FileReader reader = new FileReader(args[0]);

        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            fileText =fileText+(char)reader.read(); //читаем один символ (char будет расширен до int)
        }

        fileText.toLowerCase();


        for (char c: fileText.toCharArray()) {
           if (aString.indexOf(c) >= 0) {
                number++;
            }
        }

        System.out.println(number);
        reader.close();

    }
}
