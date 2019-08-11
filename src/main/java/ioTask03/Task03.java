package ioTask03;

//3. Написать программу для копирования всех файлов из одного каталога в
//        другой.

import org.apache.commons.lang.ArrayUtils;
import java.io.*;

public class Task03 {

    public static void main(String[] args) {
        folderFilesCopy ("src/main/resources/task03/FolderFrom", "src/main/resources/task03/FolderTo");
    }

    public static void fileCopy(InputStream in, OutputStream out) throws IOException {
        byte[] buff = new byte[64 * 1024];
        int count;

        while ((count = in.read(buff)) != -1) {
            out.write(buff, 0, count);
        }
    }

    public static void folderFilesCopy (String pathFrom, String pathTo) {
        InputStream in = null;
        OutputStream out = null;
        File dirFrom = new File(pathFrom);
        pathTo = myTrim(pathTo) + "/";

        for (File file : dirFrom.listFiles()) {
            try {
                in = new FileInputStream(file);
                out = new FileOutputStream(pathTo + file.getName());
                fileCopy(in,out);
                in.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String myTrim(String str){
        char[] redundant = new char[] {' ', '/', '\\'};
        char[] chars = str.toCharArray();
        int len = chars.length;

//                          ArrayUtils Lib is in MAVEN Dependency
        while ((0 < len) && ArrayUtils.contains(redundant, chars[len-1]) ) {
            len--;
        }
        return (len < chars.length) ? str.substring(0,len) : str;
    }
}
