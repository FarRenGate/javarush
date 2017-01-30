package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> none = new ArrayList<>();
        Human Ch1 = new Human("Ch1", false, 10, none);//напишите тут ваш код
        Human Ch2 = new Human("Ch2", false, 12, none);//напишите тут ваш код
        Human Ch3 = new Human("Ch3", true, 15, none);//напишите тут ваш код
        ArrayList<Human> ch = new ArrayList<>();
        ch.add(Ch1);
        ch.add(Ch2);
        ch.add(Ch3);
        Human Fa = new Human("Fa", true, 35, ch);//напишите тут ваш код
        Human Ma = new Human("Ma", false, 33, ch);//напишите тут ваш код

        ArrayList<Human> chFa = new ArrayList<>();
        chFa.add(Fa);
        ArrayList<Human> chMa = new ArrayList<>();
        chMa.add(Ma);
        Human GMa1 = new Human("GMa1", false, 63, chMa);//напишите тут ваш код
        Human GFa1 = new Human("GFa1", true, 63, chMa);//напишите тут ваш код
        Human GMa2 = new Human("GMa2", false, 65, chFa);//напишите тут ваш код
        Human GFa2 = new Human("GFa2", true, 65, chFa);//напишите тут ваш код

        System.out.println(GFa1.toString());
        System.out.println(GMa1.toString());
        System.out.println(GFa2.toString());
        System.out.println(GMa2.toString());
        System.out.println(Fa.toString());
        System.out.println(Ma.toString());
        System.out.println(Ch1.toString());
        System.out.println(Ch2.toString());
        System.out.println(Ch3.toString());
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human (String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }//напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
