package com.company;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int PERCENT =100;
        final int MONTHS = 12;
        Scanner sc = new Scanner(System.in);
        //Loan
        System.out.print("Principal($): ");
        int principal = sc.nextInt();
        // monthly interest
        System.out.print("Monthly interest rate: ");
        double annualInterestRate = (sc.nextDouble() / PERCENT);
        System.out.print("Period (Years): ");
        int period = sc.nextInt()*MONTHS;
        double numerator = annualInterestRate*(Math.pow((1 + annualInterestRate), (int)period));
        double denominator = (Math.pow((1+ annualInterestRate), (int)period)) -1;
        double mortgage = (int)principal * (numerator / denominator);
        NumberFormat dollar = NumberFormat.getCurrencyInstance();
        String mortgageResult = dollar.format(mortgage);
        System.out.print("Mortgage: " );
        System.out.print(mortgageResult);
    }
}

