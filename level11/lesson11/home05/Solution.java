package com.javarush.test.level11.lesson11.home05;

/* От школьника к рабству
Написать четыре класса: Schoolboy(школьник), Student(студент), Worker(Сотрудник), Slave (Раб)
Унаследовать студента от школьника, сотрудника от студента, раба от сотрудника.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Schoolboy
    {
        int a;
    }

    public class Student extends Schoolboy
    {
        int b;
    }

    public class Worker extends Student
    {
        int c;
    }

    public class Slave extends Worker
    {
        int d;
    }

}
