package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human GF1 = new Human("GF1", true, 60);
        Human GF2 = new Human("GF2", true, 60);
        Human GM1 = new Human("GM1", false, 60);//напишите тут ваш код
        Human GM2 = new Human("GM2", false, 60);//напишите тут ваш код
        Human M = new Human("M", false, 35, GF1, GM1);//напишите тут ваш код
        Human F = new Human("F", true, 35, GF2, GM2);//напишите тут ваш код
        Human S = new Human("S", true, 15, F, M);//напишите тут ваш код
        Human D = new Human("D", true, 11, F, M);
        Human D2 = new Human("D2", false, 12, F, M);

        System.out.println(GF1.toString());//напишите тут ваш код
        System.out.println(GF2.toString());//напишите тут ваш код
        System.out.println(GM1.toString());//напишите тут ваш код
        System.out.println(GM2.toString());//напишите тут ваш код
        System.out.println(F.toString());//напишите тут ваш код
        System.out.println(M.toString());//напишите тут ваш код
        System.out.println(S.toString());//напишите тут ваш код
        System.out.println(D.toString());//напишите тут ваш код
        System.out.println(D2.toString());//напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father, mother;


         Human (String name, boolean sex, int age)
        {
            this.name=name;
            this.age=age;
            this.sex=sex;
        }

         Human (String name, boolean sex, int age, Human father, Human mother)
        {
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.father=father;
            this.mother=mother;
        }
        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
