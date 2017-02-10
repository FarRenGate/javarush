package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        String firstFileName, secondFileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Solution.firstFileName = reader.readLine();
            Solution.secondFileName = reader.readLine();
        }
        catch (Exception e) {

        }

    }//add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();//add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String filename, lines="";

        public void setFileName (String filename) {
            this.filename=filename;
        }

        public String  getFileContent () {
         return this.lines;
        }

        public void run() {
            try {
                Scanner scanner = new Scanner(new File(filename));
                while (scanner.hasNextLine()) {
                   lines+=scanner.nextLine()+" ";
                }
                scanner.close();
            }
            catch (Exception e){

            }
        }

    } //add your code here - добавьте код тут
}
