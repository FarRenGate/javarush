package com.javarush.test.level11.lesson11.home03;

/* Эволюция
Написать четыре класса: Fish(Рыбы), Animal(Животные), Ape(Обезьяны), Human (Человек).
Унаследовать животных от рыб, обезьян от животных и человека от обезьян.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Fish
    {
        int a;
    }

    public class Animal extends Fish
    {
        int b;
    }

    public class Ape extends Animal
    {
        int c;
    }

    public class Human extends Ape
    {
        int d;
    }

}
