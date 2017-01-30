package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int n1=1, n2=1;
        while (n1<11) {
            while (n2<11) {
                System.out.print("S");
                n2+=1;
            }
            System.out.println();
            n1+=1;
            n2=1;//напишите тут ваш код

        } //напишите тут ваш код

    }
}
