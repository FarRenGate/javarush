package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String result = outputStream.toString();

        String [] resultSplit;
        Integer answer=0;
        result=result.replaceAll("(\\r\\n)", "");
        resultSplit=result.split(" ");
        switch (resultSplit[1]) {
            case "+":
                answer=Integer.parseInt(resultSplit[0])+Integer.parseInt(resultSplit[2]);
                break;
            case "-":
                answer=Integer.parseInt(resultSplit[0])-Integer.parseInt(resultSplit[2]);
                break;
            case "*":
                answer=Integer.parseInt(resultSplit[0])*Integer.parseInt(resultSplit[2]);
                break;
        }
        result=result+answer.toString();
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

