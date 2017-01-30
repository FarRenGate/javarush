package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Scanner scanner = new Scanner(new File(name));
               ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt())
        {
            int buf=scanner.nextInt();
            if (isEven(buf)) {
                list.add(buf); break;
            }
        }
        while (scanner.hasNextInt())
        {
            int buf=scanner.nextInt();
            if (isEven(buf)) {
                int i=0;
                while (buf>list.get(i))
                {
                    i++;
                    if (i>=list.size()) break;


                }
                list.add(i,buf);
            }

        }

        for (Integer i : list)
            System.out.println(i);// напишите тут ваш код
    }

    public static boolean isEven (int n)
    {
        if (n%2==0) return true;
        else     return false;
    }
}
