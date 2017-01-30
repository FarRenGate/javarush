package com.javarush.test.level04.lesson13.task03;

import java.io.*;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
     for (int n=1; n<11; n++){
         for (int i=0; i<n; i++)
             System.out.print(8);
        System.out.println();//напишите тут ваш код

    }}
}
