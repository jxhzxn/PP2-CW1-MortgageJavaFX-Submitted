package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWrite{

    //method to write the SimpleSaving's final calculation data in a file
    public static void simpleSaving(String fileName, double futureValue, double presentValue, double interestRate, double years) throws IOException {

        File file = new File(fileName);
        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Future Value : "+futureValue);
            printWriter.println("Present Value : "+presentValue);
            printWriter.println("Interest : "+interestRate*100+"%");
            printWriter.println("Years : "+years);
            printWriter.println("");


            printWriter.close();
        }

    }

    //method to write the CompoundSaving's final calculation data in a file
    public static void compoundSaving(String fileName, double futureValue, double presentValue, double interestRate, double payment, double years) throws IOException {

        File file = new File(fileName);
        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Future Value : "+futureValue);
            printWriter.println("Present Value : "+presentValue);
            printWriter.println("Interest : "+interestRate*100+"%");
            printWriter.println("Monthly Payment : "+payment);
            printWriter.println("Years : "+years);
            printWriter.println("");
            printWriter.close();
        }


    }

    //method to write the Loan's final calculation data in a file
    public static void loan(String fileName, double loanAmount, double monthlyPayment, double interestRate, double month) throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Loan Amount : "+loanAmount);
            printWriter.println("Monthly Payment : "+monthlyPayment);
            printWriter.println("Interest : "+interestRate*100+"%");
            printWriter.println("Loan Month Terms : "+monthlyPayment);
            printWriter.println("");
            printWriter.close();
        }
    }

    //method to write the Mortgage's final calculation data in a file
    public static void mortgage(String fileName, double mortgageAmount, double downPayment, double mortgageTerm, double interestRate, double monthPayment) throws IOException {

        File file = new File(fileName);
        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Mortgage Amount : "+mortgageAmount);
            printWriter.println("Down Payment : "+downPayment);
            printWriter.println("Mortgage Term : "+mortgageTerm);
            printWriter.println("Interest : "+interestRate*100+"%");
            printWriter.println("Monthly Payment : "+monthPayment);
            printWriter.println("");
            printWriter.close();
        }

    }

}
