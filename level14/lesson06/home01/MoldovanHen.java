package com.javarush.test.level14.lesson06.home01;

/**
 * Created by User on 22/01/17.
 */
public class MoldovanHen extends Hen {
    int getCountOfEggsPerMonth() {return 25;}
    String getDescription() {return super.getDescription()+" Моя страна - Moldova. Я несу 25 яиц в месяц.";}
}
