package com.company;

import java.util.Scanner;

public class Product {
    private double moneyBought, moneySold;
    private int inHand;
    public static String newline = System.getProperty("line.separator");
    public void newOne()
    {
        Scanner in=new Scanner(System.in);
        System.out.print("въведете колко струваше:");
        moneyBought=in.nextDouble();
        System.out.print("въведете колко ще струва:");
        moneySold=in.nextDouble();
        System.out.print("въведете наличност:");
        inHand=in.nextInt();

    }
    public String getInfo()
    {
        return newline+String.valueOf(moneyBought)+newline+String.valueOf(moneySold)+newline+ String.valueOf(inHand);
    }
}
