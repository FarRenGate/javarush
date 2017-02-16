package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> result = new HashMap<>();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int buf, bytenumber=0;

        while (inputStream.available()>0) {
            buf=inputStream.read();
            bytenumber++;
            if (result.containsKey(buf)) {
                result.put(buf,result.get(buf)+1);
            }
            else {
                result.put(buf,1);
            }
        }


        for (Map.Entry<Integer,Integer> entry : result.entrySet()) {
            bytenumber=Math.min(bytenumber,entry.getValue());
        }

        for (Map.Entry<Integer,Integer> entry : result.entrySet()) {
            if (entry.getValue()==bytenumber) {
                System.out.printf(entry.getKey()+" ");
            }
        }
        reader.close();
        inputStream.close();
    }
}
