package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by User on 23/01/17.
 */
class Singleton {
    private static Singleton instance; //declare our singleton, private static == can be called ONLY form singleton itself!

    private Singleton() //constructor does nothing
    {
    }

    public static Singleton getInstance() // return our Singleton
    {
        if (instance == null) instance=new Singleton(); // if no singleton was created - create the first and only one
        return instance;

    }

}
