package com.javamortgagecalc;

import java.text.NumberFormat;
import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        // Get user input in command line
        Scanner scanner = new Scanner(System.in);

        // Get user Principal amount
        System.out.print("Principal: ");
        double principal = scanner.nextDouble();

        // Get user interest rate
        System.out.print("Annual Interest Rate: ");
        float apr = scanner.nextFloat();
        float monthlyRate = apr / PERCENT / MONTHS_IN_YEAR;

        // Get user loan period
        System.out.print("Period (Years): ");
        byte loanYears = scanner.nextByte();
        int numberOfPayments = loanYears * MONTHS_IN_YEAR;

        // Calculate Mortgage Payment
        double mortgagePmt = principal
                * (monthlyRate * Math.pow((1 + monthlyRate), numberOfPayments) / (Math.pow((1 + monthlyRate), numberOfPayments) - 1));
        String pmtFormat = NumberFormat.getCurrencyInstance().format(mortgagePmt);
        
        // Print Results
        System.out.println("Mortgage: " + pmtFormat);
    }
}
