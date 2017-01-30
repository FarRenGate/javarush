package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Map<String,String> map = new HashMap<>();

        map.put("арбуз", "ягода");//напишите тут ваш код
        map.put("банан", "трава");//напишите тут ваш код
        map.put("вишня", "ягода");//напишите тут ваш код
        map.put("груша", "фрукт");//напишите тут ваш код
        map.put("дыня", "овощ");//напишите тут ваш код
        map.put("ежевика", "куст");//напишите тут ваш код
        map.put("жень-шень", "корень");//напишите тут ваш код
        map.put("земляника", "ягода");//напишите тут ваш код
        map.put("ирис", "цветок");//напишите тут ваш код
        map.put("картофель", "клубень");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();            //ключ
            String value = pair.getValue();        //значение
            System.out.println(key + " - " + value);
        }//напишите тут ваш код

    }
}
