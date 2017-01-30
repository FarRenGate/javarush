package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        ns=reader.readLine();
        int n4=Integer.parseInt(ns);
        int max=n1;
        if (n2>max) max=n2;
        if (n3>max) max=n3;
        if (n4>max) max=n4;
        System.out.println(max);//напишите тут ваш код

    }
}
