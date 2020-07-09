package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileTempoWrite{

    public static void simpleSaving(String fileName, String futureValue, String presentValue, String interestRate, String years) throws IOException {

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(futureValue);
        printWriter.println(presentValue);
        printWriter.println(interestRate);
        printWriter.println(years);

        printWriter.close();

    }

    public static void compoundSaving(String fileName, String futureValue, String presentValue, String interestRate, String payment, String years) throws IOException {

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(futureValue);
        printWriter.println(presentValue);
        printWriter.println(interestRate);
        printWriter.println(payment);
        printWriter.println(years);

        printWriter.close();

    }

    public static void loan(String fileName, String loanAmount, String monthlyPayment, String interestRate, String month) throws IOException {

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(loanAmount);
        printWriter.println(monthlyPayment);
        printWriter.println(interestRate);
        printWriter.println(month);

        printWriter.close();

    }

}