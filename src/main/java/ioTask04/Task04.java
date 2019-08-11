package ioTask04;

//4. Написать программу, которая создаст текстовый файл и запишет в него
//        список файлов (путь, имя, дата создания) из заданного каталога.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;

public class Task04 {

    public static void main(String[] args) /*throws IOException*/ {
        String dirPath = "src/main/resources/task04/Folder";
        String filePath = "src/main/resources/task04/listOfFiles.txt";

        try {
            writeFolderListIntoFile(dirPath, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFolderListIntoFile(String dirPath, String filePath) throws IOException {
        BufferedWriter writer = null;
        File dir = new File(dirPath);
        BasicFileAttributes attr = null;
        String str = "===== List of files of \"" + dirPath + "\" folder =====\n";

        for (File file : dir.listFiles()) {
            attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            str += "name: " + file.getName() + "\n"
                    + "path: " + file.getPath() + "\n"
//              + "lastModified(TimeStamp): " + file.lastModified() + "\n"
//              + "lastModified: " + new Date(file.lastModified()) + "\n"
                    + "Creation date: " + attr.creationTime() + "\n"
                    + "Last access date: " + attr.lastAccessTime() + "\n"
                    + "Last modified date: " + attr.lastModifiedTime() + "\n";
            str += "========== ========== ========== ==========\n";
        }
        str += "\nThis list was created " +  LocalDateTime.now() +"\n";
        writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(str);
        writer.close();
    }
}
