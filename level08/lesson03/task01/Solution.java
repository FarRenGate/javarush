package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Iterator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashSet<String> set = new HashSet<>();
        set.add("арбуз");//напишите тут ваш код
        set.add("банан");//напишите тут ваш код
        set.add("вишня");//напишите тут ваш код
        set.add("груша");//напишите тут ваш код
        set.add("дыня");//напишите тут ваш код
        set.add("ежевика");//напишите тут ваш код
        set.add("жень-шень");//напишите тут ваш код
        set.add("земляника");//напишите тут ваш код
        set.add("ирис");//напишите тут ваш код
        set.add("картофель");//напишите тут ваш код

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext())        //проверка, есть ли ещё элементы
        {
            //получение текущего элемента и переход на следующий
                      System.out.println(iterator.next());
        }

    }
}
