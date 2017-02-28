package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileText="";

        String f1 = reader.readLine();
        String f2 = reader.readLine();

        FileReader fileR = new FileReader(f1);

        while (fileR.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            fileText =fileText+(char)fileR.read(); //читаем один символ (char будет расширен до int)
        }

        fileR.close();

        FileWriter fileW = new FileWriter(f1);
        fileR = new FileReader(f2);

        while (fileR.ready()) //пока есть непрочитанные байты в потоке ввода
        {

            fileW.write(fileR.read()); //пишем один символ (int будет обрезан/сужен до char)
        }

        fileW.write(fileText);

        fileW.close();
        fileR.close();
        reader.close();

    }
}
