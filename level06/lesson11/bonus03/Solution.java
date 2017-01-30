package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] array  = new int[5];
        for (int i=0; i<5; i++)
        {
            array[i]=Integer.parseInt(reader.readLine());
        }

        int left=0, right=4;

        while (left<=right)
        {
            for (int i = left; i < right; i++)
            {
                if(array[i] > array[i+1])
                {
                    int k=array[i];
                    array[i]=array[i+1];
                    array[i+1]=k;
                }
            }
            right--; // уменьшаем правую границу
            //Сдвигаем к началу массива "легкие элементы"
            for (int i = right; i > left ; i--)
            {
                if(array[i] < array[i-1])
                {
                    int k=array[i];
                    array[i]=array[i-1];
                    array[i-1]=k;
                }
            }
            left++;
        }

        for (int i=0; i<5; i++)
        System.out.println(array[i]);//напишите тут ваш код
    }
}
