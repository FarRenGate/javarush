package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Integer> result = new TreeSet<>();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available()>0) {
            result.add(inputStream.read());
        }

        for (Integer i: result) {
            System.out.print(i+" ");
        }

        reader.close();
        inputStream.close();
    }
}
