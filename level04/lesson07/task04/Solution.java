package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        if (n1>0) np++; else if (n1<0) nn++;
        if (n2>0) np++; else if (n2<0) nn++;
        if (n3>0) np++; else if (n3<0) nn++;
        System.out.println("количество отрицательных чисел: "+nn);
        System.out.println("количество положительных чисел: "+np);//напишите тут ваш код

    }
}
