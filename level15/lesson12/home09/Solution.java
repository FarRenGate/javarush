package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution   {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> parameters = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        String url = reader.readLine();
        String param = url.substring(url.indexOf('?')+1); // isolating parameters
        String[] urlParts = param.split("\\&"); // split parameters (separated by &)
        for (String s : urlParts)
        {
            String[] paramParts = s.split("="); // separate parameters and value
            parameters.add(paramParts[0]);
            if (paramParts[0].equals("obj")&&(paramParts.length>1)) values.add(paramParts[1]);// if "obj" and has value
    }


    for (String s: parameters)
        {
            System.out.print(s+" ");
        }
        System.out.println();

        for (String s: values)
        {
            try
            {
                alert(Double.parseDouble(s));//if parses to double - OK
            }
            catch (Exception e)
            {
                alert(s); // otherwise - string
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
