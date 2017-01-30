package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int buf;
        if (n1<n2) {
            buf=n1;
            n1=n2;
            n2=buf;
        }
        if (n2<n3)
        {
            buf=n2;
            n2=n3;
            n3=buf;
        }
        if (n1<n2) {
            buf=n1;
            n1=n2;
            n2=buf;
        }

        System.out.println(n1+" "+n2+" "+n3);//напишите тут ваш код

    }

}
