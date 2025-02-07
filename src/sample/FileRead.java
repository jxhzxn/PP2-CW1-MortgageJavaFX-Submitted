package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
    //class to read the strings in a file line by line
    public static String read(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);

        String fileRead = "";
        while(reader.hasNextLine()){
            fileRead = fileRead.concat(reader.nextLine() + "\n");
        }
        return fileRead;
    }
}
