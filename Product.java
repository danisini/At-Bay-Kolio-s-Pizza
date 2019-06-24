package com.company;

import java.util.Scanner;

public class Product {
    private double moneyBought, moneySold, moneyTaken;
    private int inHand;

    public Product()
    {
        Scanner in=new Scanner(System.in);
        System.out.print("въведете колко струваше:");
        moneyBought=in.nextDouble();
        System.out.print("въведете колко ще струва:");
        moneySold=in.nextDouble();
        System.out.print("въведете наличност:");
        inHand=in.nextInt();
        moneyTaken=0.0;

    }
    public String getInfo()
    {
        return '\n'+String.valueOf(moneyBought)+'\n'+String.valueOf(moneySold)+'\n'+String.valueOf(moneyTaken)+'\n'+ String.valueOf(inHand);
    }
}
