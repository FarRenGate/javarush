package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileProperties = new FileInputStream(reader.readLine());
        load(fileProperties);
        reader.close();
        fileProperties.close();

        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();
        for (String key: Solution.properties.keySet()) {
            properties.put(key, Solution.properties.get(key));
        }
        properties.store(outputStream, "");
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties properties = new Properties();
        properties.load(inputStream);
        for (String key : properties.stringPropertyNames())
        {
            Solution.properties.put(key,properties.get(key).toString());
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
