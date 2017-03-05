package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args){



    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner=fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] personData;
            DateFormat df = new SimpleDateFormat("dd MM yyyy");
            Date dateOfBirth=null;
            if (this.fileScanner.hasNextLine())
            {
                personData=this.fileScanner.nextLine().split(" ");
            } else
                return null;
            if (personData.length==6)
            {
                try {

                    dateOfBirth = df.parse(personData[3] + " " + personData[4] + " " + personData[5]);
                }
                catch (Exception e)
                {

                }
            }
            else return null;
            return new Person(personData[1],personData[2],personData[0],dateOfBirth);



        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
