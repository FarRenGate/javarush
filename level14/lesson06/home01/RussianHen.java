package com.javarush.test.level14.lesson06.home01;

/**
 * Created by User on 22/01/17.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth() {return 12;}
    String getDescription() {return super.getDescription()+" Моя страна - Russia. Я несу 12 яиц в месяц.";}
}
