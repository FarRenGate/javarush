package com.javarush.test.level11.lesson11.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное и максимальное числа в массиве.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return new Pair<Integer, Integer>(null, null);
        }

        Sort(array);
        //Напишите тут ваше решение

        return new Pair<Integer, Integer>(array[0], array[array.length-1]);
    }


    public static class Pair<X, Y>
    {
        public X x;
        public Y y;

        public Pair(X x, Y y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void Sort (int[] array)
    {
        int h=1;
        while (h*3<array.length)
            h=h*3+1;

        while (h>=1)
        {
            hSort(array,h);
            h=h/3;
        }

    }

    public static void hSort (int[] array, int h)
    {
        int length = array.length;
        for (int i=h; i<array.length; i++)
            for (int j=i; j>=h; j=j-h )
            {
                if (array[j]<array[j-h]) Swap(array,j,j-h);
                else break;
            }
    }

    public static void Swap (int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
