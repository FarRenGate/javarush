package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));
        String  line;
        String[] separateLine;

        while (in.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            line=in.readLine();
            separateLine=line.split(" ");
            for (String s: separateLine) {
                try {
                    Integer.parseInt(s);
                    out.write(s+" ");
                }
                catch (Exception e) {

                }

            }

        }

        reader.close();
        in.close();
        out.close();
    }
}
