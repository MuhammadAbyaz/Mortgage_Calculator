package com.company;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //Constants
        final int PERCENT =100;
        final int MONTHS = 12;

        Scanner sc = new Scanner(System.in);

        //Loan
        System.out.print("Principal($): ");
        int principal = sc.nextInt();

        // monthly interest
        System.out.print("Monthly interest rate: ");
        double annualInterestRate = sc.nextDouble();
        double monthlyInterestRate = annualInterestRate/ PERCENT;

        //Period
        System.out.print("Period (Years): ");
        byte period = sc.nextByte();
        int numberOfPayments = period*MONTHS;

        //numerator
        double numerator = monthlyInterestRate*(Math.pow((1 + monthlyInterestRate), (int)numberOfPayments));

        //denominator
        double denominator = (Math.pow((1+ monthlyInterestRate), (int)numberOfPayments)) -1;

        //Mortgage
        double mortgage = (int)principal * (numerator / denominator);
        NumberFormat dollar = NumberFormat.getCurrencyInstance();
        String mortgageResult = dollar.format(mortgage);
        System.out.print("Mortgage: " );
        System.out.print(mortgageResult);
    }
}

