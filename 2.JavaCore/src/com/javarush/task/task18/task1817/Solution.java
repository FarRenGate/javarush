package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileReader;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {

        int numberOfSymbols=0, numberOfSpaces=0;

        FileReader reader = new FileReader(args[0]);

        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            numberOfSymbols++;
            if ((char)reader.read()==' ') {
                numberOfSpaces++;//читаем один символ (char будет расширен до int)
            }
        }
        reader.close();

        System.out.println(String.format(Locale.ENGLISH, "%.2f", (double)numberOfSpaces/numberOfSymbols*100));
    }
}
