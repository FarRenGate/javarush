package com.javarush.test.level04.lesson07.task01;

/* Строка - описание
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» - если число отрицательное и четное,
«отрицательное нечетное число» - если число отрицательное и нечетное,
«нулевое число» - если число равно 0,
«положительное четное число» - если число положительное и четное,
«положительное нечетное число» - если число положительное и нечетное.
Пример для числа 100:
положительное четное число
Пример для числа -51:
отрицательное нечетное число
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ns=reader.readLine();
        int n1=Integer.parseInt(ns);
        String se, sn;
        if (n1==0) System.out.println("нулевое число");
        else{
        if (n1 % 2 == 0) se = "четное ";
            else se = "нечетное ";
            if (n1 > 0) sn = "положительное ";
            else sn = "отрицательное ";//напишите тут ваш код
            System.out.println(sn+se+"число");
        }
//напишите тут ваш код

    }
}
