package ioTask01;

//1. Написать программу, которая считает текстовый файл,
//  заменит в нем все слова “Hello” на “1234” и запишет изменения в тот-же файл.

import jdk.internal.util.xml.impl.Input;
import jdk.internal.util.xml.impl.ReaderUTF8;
import org.omg.CORBA.portable.InputStream;
import java.io.InputStreamReader;

import java.io.*;
import java.util.ArrayList;

public class Task01 {

    public static void main(String[] args) {

        String fileName = "src/main/resources/task01File.txt";
        ArrayList<Byte> list = new ArrayList<Byte>();
        char[] buff = new char[64 * 1024];
        int count; //, len = 0;
        String str = "";
        FileReader in = null;
        FileWriter out = null;

        try {
            long startTime  = System.currentTimeMillis();
            in = new FileReader(fileName);
            while ((count = in.read(buff)) != -1) {
                for (int i = 0; i < count; i++) {
                    str += buff[i];
                }
                buff = new char[64 * 1024];
            }
            System.out.println("str1:" + str.length());
            str = str.replaceAll("Hello", "1234");
            out = new FileWriter(fileName);
            System.out.println("str2:" + str.length());
//            out.write(str, 0, len);
            out.write(str);
            out.close();
            long stopTime = System.currentTimeMillis();
            System.out.println("Result Task01 time is: " + (stopTime - startTime));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }






    }

}
