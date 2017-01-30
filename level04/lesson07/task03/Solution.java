package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ns=reader.readLine();
        int n1=Integer.parseInt(ns);
        ns=reader.readLine();
        int n2=Integer.parseInt(ns);
        ns=reader.readLine();
        int n3=Integer.parseInt(ns);
        int np=0, nn=0;
        if (n1>0) np++;
        if (n2>0) np++;
        if (n3>0) np++;
         System.out.println(+np);//напишите тут ваш код

    }
}
