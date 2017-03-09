package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));
          char readSymbol;

        while (in.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            out.write(in.readLine().replace('.','!'));
            out.newLine();

            //читаем один символ (char будет расширен до int)
        }

        reader.close();
        in.close();
        out.close();

    }
}
