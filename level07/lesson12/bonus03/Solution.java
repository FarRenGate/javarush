package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        int left = 0;
        int right = array.length-1;
        while (left<=right)
        {
            for (int i = left; i < right; i++) {
                if (array[i] < array[i + 1]) {
                    int buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
                right--;

                for (int i = right; i > left; i--) {
                    if (array[i] > array[i - 1])
                    {
                        int buf = array[i];
                        array[i]=array[i-1];
                        array[i-1]=buf;
                    }

            }
            left++;//напишите тут ваш код
        }
    }
}
