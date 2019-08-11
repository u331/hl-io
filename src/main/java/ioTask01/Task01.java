package ioTask01;

//1. Написать программу, которая считает текстовый файл,
//  заменит в нем все слова “Hello” на “1234” и запишет изменения в тот-же файл.

import java.io.*;

public class Task01 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/task01File.txt";
        char[] buff = new char[64 * 1024];
        int count;
        String str = "";
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader(fileName);
            while ((count = in.read(buff)) != -1) {
                for (int i = 0; i < count; i++) {
                    str += buff[i];
                }
                buff = new char[64 * 1024];
            }
            in.close();
            str = str.replaceAll("Hello", "1234");
            out = new FileWriter(fileName);
            out.write(str);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
