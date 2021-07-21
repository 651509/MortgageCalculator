package com.codewithakash;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public double mortgage(int principal, double rateOfInterest, int periodInYears){

        final byte MONTHS_IN_YEAR=12;
        final byte PERCENT=100;

        double monthlyInterest = rateOfInterest/PERCENT/MONTHS_IN_YEAR;

        double numberOfYears= periodInYears*MONTHS_IN_YEAR;

        double mortgage=principal
                *(monthlyInterest* (Math.pow((1+monthlyInterest), numberOfYears))
                /((Math.pow((1+monthlyInterest), numberOfYears)-1)));

        String mortgageFormatted= NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: "+mortgageFormatted);
        return mortgage;
    }



    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = sc.nextInt();

        System.out.print("Annual Interest Rate: ");
        double rateOfInterest= sc.nextDouble();

        System.out.print("Period: ");
        int periodInYears = sc.nextInt();

        MortgageCalculator mc = new MortgageCalculator();
       mc.mortgage(principal, rateOfInterest, periodInYears );


    }
}
