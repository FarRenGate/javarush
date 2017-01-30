package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try //ArithmeticException
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //ArrayIndexOutOfBoundsException
        {
            int[] a = {1,2};
            a[3]=0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //ArrayStoreException
        {
            Object szStr[] = new String[10];
            szStr[0] = new Character('*');

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //ClassCastException
        {
            Object ch = new Character('*');
            System.out.println((Byte)ch);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //NegativeArraySizeException
        {
            int[] nNegArray = new int[-5];

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //NullPointerException
        {
            int[] nNulArray = null;
            int i = nNulArray.length;


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //NumberFormatException
        {
            int i = Integer.parseInt("String");

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try //FileNotFoundException
        {
            FileInputStream fis = new FileInputStream("nofile.txt");

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try // IllegalArgumentException
        {
            throw new IllegalArgumentException();


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try // IllegalArgumentException
        {
            throw new NoSuchMethodException  ();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

    }
}
