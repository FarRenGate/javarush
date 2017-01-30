package com.javarush.test.level11.lesson11.home04;

/* Религии
Написать три класса: Judaism(Иудаизм), Christianity(Христианство), Islam(Мусульманство)
Унаследовать христианство от иудаизма и мусульманство от христианства.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Judaism
    {
        int a;
    }

    public class Christianity extends Judaism
    {
        int b;
    }

    public class Islam extends Christianity
    {
        int c;
    }

}
