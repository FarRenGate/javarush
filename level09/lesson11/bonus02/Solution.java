package com.javarush.test.level09.lesson11.bonus02;

import java.io.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Новая задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Если файла (который нужно копировать) с указанным именем не существует, то
программа должна вывести надпись «Файл не существует.» и еще раз прочитать имя файла с консоли, а уже потом считывать файл для записи.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName;
        FileInputStream fileInputStream;
        while (true) {
            int flag =1;
            sourceFileName = reader.readLine();
            try {
                fileInputStream = new FileInputStream(sourceFileName);
            }
            catch (Exception e)
            {
                System.out.println("Файл не существует.");
                flag=0;
            }
            if (flag ==1) break;
        }

        fileInputStream = new FileInputStream(sourceFileName);
        String destinationFileName = reader.readLine();


        FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
