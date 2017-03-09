package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter out = new BufferedWriter(new FileWriter(reader.readLine()));
        String  line="";

        while (in.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            line=line+in.readLine();
        }

        line = line.replaceAll("\\p{Punct}", "");
        out.write(line);

        reader.close();
        in.close();
        out.close();
    }
}
