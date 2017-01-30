package com.javarush.test.level05.lesson12.home04;
import java.util.*;
import java.text.*;
/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

public class Solution
{
    public static void main(String[] args)
    {
        Date today = new Date();
        SimpleDateFormat ft =    new SimpleDateFormat ("dd MM yyyy");
        System.out.println(ft.format(today));//напишите тут ваш код
    }
}
