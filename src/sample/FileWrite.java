package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite{

    public static void write(String fileName, double futureValue, double presentValue, double interestRate, double years) throws IOException {

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("Future Value : "+futureValue);
        printWriter.println("Present Value : "+presentValue);
        printWriter.println("Interest : "+interestRate*100+"%");
        printWriter.println("Years : "+years);

        printWriter.close();

    }

}
