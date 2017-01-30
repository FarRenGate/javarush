package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> length = new ArrayList<>();
        int max=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<5; i++)
        {
            list.add(reader.readLine());//напишите тут ваш код
        }

        for (int i=0; i<5; i++)
        {
           length.add(list.get(i).length());
           if (list.get(i).length()>max) max=list.get(i).length();//напишите тут ваш код
        }

        for (int i=0; i<5; i++)
        {
            if (length.get(i).equals(max)) System.out.println(list.get(i));//напишите тут ваш код
        }
    }
}
