package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        HashMap<String, Integer> months = new HashMap<>();
        months.put("January", 1);//напишите тут ваш код
        months.put("February", 2);//напишите тут ваш код
        months.put("March",3 );//напишите тут ваш код
        months.put("April",4);//напишите тут ваш код
        months.put("May",5);//напишите тут ваш код
        months.put("June",6);//напишите тут ваш код
        months.put("July",7);//напишите тут ваш код
        months.put("August",8);//напишите тут ваш код
        months.put("September",9);//напишите тут ваш код
        months.put("October",10);//напишите тут ваш код
        months.put("November",11);//напишите тут ваш код
        months.put("December",12);//напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println(name+" is "+months.get(name)+" month");
    }

}
