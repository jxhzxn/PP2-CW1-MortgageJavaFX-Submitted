package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReadTemp {
    //method to read the string from a file and saving the elements in an ArrayList
    public static List<String> read(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        List<String> readList = new ArrayList<>();

        while(reader.hasNextLine()){
            readList.add(reader.nextLine());
        }
        return readList;
    }
}