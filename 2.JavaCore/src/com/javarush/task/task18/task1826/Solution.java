package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{

        if (args[0].equals("-e")) {
            encrypt(args[1],args[2]);
        } else if (args[0].equals("-d")) {
            decrypt(args[1],args[2]);
        }

    }

    static void encrypt (String InputFileName, String OutputFileName) throws Exception{


        FileInputStream inputStream = new FileInputStream(InputFileName);
        FileOutputStream outputStream = new FileOutputStream(OutputFileName);

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int b = inputStream.read();
            outputStream.write(encrypt(b));
        }

        inputStream.close();
        outputStream.close();

    }

    static void decrypt (String InputFileName, String OutputFileName) throws Exception{
        FileInputStream inputStream = new FileInputStream(InputFileName);
        FileOutputStream outputStream = new FileOutputStream(OutputFileName);

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int b = inputStream.read();
            outputStream.write(decrypt(b));
        }

        inputStream.close();
        outputStream.close();
    }

    static int encrypt (int b) {
        if (b<127) {
            return ++b;
        }
        else {
            return -128;
        }
    }

    static int decrypt (int b) {
        if (b!=-128) {
            return --b;
        }
        else {
            return 127;
        }
    }
}
