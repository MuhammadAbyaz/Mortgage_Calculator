package com.company;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //variables
        int principal = 0;
        double monthlyInterestRate = 0;
        int numberOfPayments = 0;
        
        //Constants
        final int PERCENT =100;
        final int MONTHS = 12;
        final int oneK = 1000;
        final long oneM = 100_000_0L;

        Scanner sc = new Scanner(System.in);

        //Loan
        while (true){
            System.out.print("Principal($1k - $1M): ");
            principal = sc.nextInt();
            if(principal >= oneK && principal <= oneM)
                break;
                System.out.println("Enter a value between 1,000 to 1,000,000");
        }

        // monthly interest
        while(true){
            System.out.print("Annual interest rate: ");
            double annualInterestRate = sc.nextDouble();
            if ( annualInterestRate >= 0 && annualInterestRate <=30){
                monthlyInterestRate = annualInterestRate/ PERCENT/MONTHS;
                break;
            }
            System.out.println("Enter a value greater than 0 or less than equal to 30");
        }

        //Period
        while (true){
            System.out.print("Period (Years): ");
            int period = sc.nextByte();
            if (period >= 1 && period <= 30) {
                numberOfPayments = period * MONTHS;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        //numerator
        double numerator = monthlyInterestRate*(Math.pow((1 + monthlyInterestRate), (int)numberOfPayments));

        //denominator
        double denominator = (Math.pow((1+ monthlyInterestRate), (int)numberOfPayments)) -1;

        //Mortgage
        double mortgage = (int)principal * (numerator / denominator);
        NumberFormat dollar = NumberFormat.getCurrencyInstance();
        String mortgageResult = dollar.format(mortgage);
        System.out.print("Mortgage: " + mortgageResult);
    }
}

