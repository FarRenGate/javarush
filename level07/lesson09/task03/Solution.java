package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("мама"); //0
        list.add("мыла"); //1
        list.add("раму"); //2//напишите тут ваш код

        for (int i=list.size()-1; i>=0; i--)
        {
            list.add(i+1,"именно");
        }

        for (String s: list ) System.out.println(s);

    }
}
