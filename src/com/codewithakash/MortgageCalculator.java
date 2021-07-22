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
        int principal,periodInYears;
        double rateOfInterest;

        while(true){
            System.out.print("Principal: ");
            principal=sc.nextInt();
            if(principal>=1000 && principal<=1_00_000)
                break;
            System.out.println("Enter a number between 1000 and 100000");
        }

        while(true){
            System.out.print("Annual Rate of Interest: ");
            rateOfInterest=sc.nextDouble();
            if(rateOfInterest>0 && rateOfInterest<=30)
                break;
            System.out.println("Enter a value between 0 and 30");
        }

        while(true){
            System.out.print("Periods: ");
            periodInYears=sc.nextInt();
            if(periodInYears>0 && periodInYears<=30)
                break;
            System.out.println("Enter a value between 0 and 30");
        }


        MortgageCalculator mc = new MortgageCalculator();
        mc.mortgage(principal, rateOfInterest, periodInYears );


    }
}
