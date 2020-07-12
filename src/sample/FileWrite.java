package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWrite{

    public static void simpleSaving(String fileName, double futureValue, double presentValue, double interestRate, double years) throws IOException {

        File file = new File(fileName);
        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Future Value : "+futureValue);
            printWriter.println("Present Value : "+presentValue);
            printWriter.println("Interest : "+interestRate*100+"%");
            printWriter.println("Years : "+years);

            printWriter.close();
        }

    }

    public static void compoundSaving(String fileName, double futureValue, double presentValue, double interestRate, double payment, double years) throws IOException {

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("Future Value : "+futureValue);
        printWriter.println("Present Value : "+presentValue);
        printWriter.println("Interest : "+interestRate*100+"%");
        printWriter.println("Monthly Payment : "+payment);
        printWriter.println("Years : "+years);

        printWriter.close();

    }

    public static void loan(String fileName, double loanAmount, double monthlyPayment, double interestRate, double month) throws IOException {

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        Scanner reader = new Scanner(file);

        while(reader.hasNextLine()){
            printWriter.println("Loan Amount : "+loanAmount);
            printWriter.println("Monthly Payment : "+monthlyPayment);
            printWriter.println("Interest : "+interestRate*100+"%");
            printWriter.println("Loan Month Terms : "+month);
        }


        printWriter.close();

    }

}
