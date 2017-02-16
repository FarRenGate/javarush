package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileName2);
        FileOutputStream outputStream2 = new FileOutputStream(fileName3);

        if (inputStream.available() > 0) {
            if (inputStream.available() >=0) {
                //читаем весь файл одним куском
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, (int)Math.ceil(count/2.));

                outputStream2.write(buffer, (int)Math.ceil(count/2.), count-(int)Math.ceil(count/2.));
            }
        }
        inputStream.close();
        outputStream.close();
        outputStream2.close();
    }
}
