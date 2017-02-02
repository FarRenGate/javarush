package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by User on 01/02/17.
 */
public class LatteMaker extends DrinkMaker {
    void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }

    @Override
    void putIngredient() {
        System.out.println("Делаем кофе");
    }

    @Override
    void pour() {
        System.out.println("Заливаем молоком с пенкой");
    }
}
