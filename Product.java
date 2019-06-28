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
    public String getMoneyBought()
    {
        return String.valueOf(moneyBought);
    }
    public String getMoneySold()
    {
        return String.valueOf(moneySold);
    }
    public String getInHand()
    {
        return String.valueOf(inHand);
    }
}
