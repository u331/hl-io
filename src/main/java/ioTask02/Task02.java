package ioTask02;

//2. Написать программу, которая скопирует несколько файлов в один.

import org.apache.commons.lang.ArrayUtils;

import java.io.*;
import java.util.ArrayList;

public class Task02 {

    public static void file_into_byteAL(String fileName, ArrayList<Byte> al){
        int count;
        byte[] buff = new byte[64 * 1024];
        FileInputStream in = null;

        try {
            in = new FileInputStream(fileName);
            while ((count = in.read(buff)) != -1) {
                for (int i = 0; i < count; i++) {
                    al.add(buff[i]);
                }
                buff = new byte[64 * 1024];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void byteAL_into_file(ArrayList<Byte> al, String fileName){
        FileOutputStream out = null;

        try{
            out = new FileOutputStream(fileName);
    //        ArrayUtils in the MAVEN dependency
            byte[] byteArray =   ArrayUtils.toPrimitive( al.toArray(new Byte[al.size()]) );
            out.write(byteArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mergeFiles (String inFileName1, String inFileName2, String outFileName){
        ArrayList<Byte> byteArrayList = new ArrayList<Byte>();

        file_into_byteAL(inFileName1, byteArrayList);
        file_into_byteAL(inFileName2, byteArrayList);
        byteAL_into_file(byteArrayList, outFileName);
    }

    public static void main(String[] args) {

        String fileNameA = "src/main/resources/task02FileA.txt",
            fileNameB = "src/main/resources/task02FileB.txt",
            fileNameC = "src/main/resources/task02FileC.txt";

        // B + C => A
        mergeFiles(fileNameB, fileNameC, fileNameA);

    }

}
