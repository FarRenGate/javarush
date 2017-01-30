package com.javarush.test.level14.lesson06.home01;

/**
 * Created by User on 22/01/17.
 */
public class UkrainianHen extends Hen {
    int getCountOfEggsPerMonth() {return 10;}
    String getDescription() {return super.getDescription()+" Моя страна - Ukraine. Я несу 10 яиц в месяц.";}
}
