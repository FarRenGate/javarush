package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> result = new HashMap<>();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int buf;

        while (inputStream.available()>0) {
            buf=inputStream.read();
            if (result.containsKey(buf)) {
                result.put(buf,result.get(buf)+1);
            }
            else {
                result.put(buf,1);
            }
        }

        buf=0;

        for (Map.Entry<Integer,Integer> entry : result.entrySet()) {
            buf=Math.max(buf,entry.getValue());
        }

        for (Map.Entry<Integer,Integer> entry : result.entrySet()) {
            if (entry.getValue()==buf) {
                System.out.printf(entry.getKey()+" ");
            }
        }
        reader.close();
        inputStream.close();
    }
}
