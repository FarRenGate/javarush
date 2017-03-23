package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {


        Solution savedObject = new Solution(10);


        FileOutputStream fileWrite = new FileOutputStream("C:/tmp/text.txt");

        ObjectOutputStream outputStream = new ObjectOutputStream(fileWrite);
        outputStream.writeObject(savedObject);
        fileWrite.close();
        outputStream.close();


        FileInputStream fileRead = new FileInputStream("C:/tmp/text.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileRead);

        Solution loadedObject = (Solution)inputStream.readObject();
        fileRead.close();
        inputStream.close();

        System.out.println(savedObject.toString());

        System.out.println(loadedObject.toString());





    }



    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution() {

    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
