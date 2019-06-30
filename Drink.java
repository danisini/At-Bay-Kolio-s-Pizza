package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Drink extends Product {
    private String size , name ,description;//big,medium,small
    public static String newline = System.getProperty("line.separator");
    private String[] pArray;
    public void newDrink()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Въведете име на напитката:");
        name = in.nextLine();
        System.out.print("Въведете големина на напитката:");
        size = in.nextLine();
        System.out.print("Въведете описание на напитката:");
        description = in.nextLine();
        String[][] drinkArray;
        drinkArray = new String[128][8];
        FileManage fM = new FileManage();
        drinkArray = fM.FileRead("drink.txt");
        Product drink = new Product();
        drink.newOne();
        String moneyBought = drink.getMoneyBought();
        String moneySold = drink.getMoneySold();
        String moneyInHand = drink.getInHand();
        int indx = fM.seeLenght(drinkArray);
        drinkArray[indx][0] = String.valueOf(indx + 1) + " " + name + " " + size;
        drinkArray[indx][1] = description;
        drinkArray[indx][2] = moneyBought;
        drinkArray[indx][3] = moneySold;
        drinkArray[indx][4] = moneyInHand;
        indx ++;
        fM.FileWrite("drink.txt" , drinkArray , indx);
    }
    public void EditDrink(int number){
        String[][] drinkArray;
        drinkArray = new String [128][8];
        FileManage fM = new FileManage();
        drinkArray = fM.FileRead("drink.txt");
        System.out.print("За да смените името и големината-въведете 1, за описание-2, за цена на купуване-3, за цена на продажба-4, за наличност-5:");
        Scanner in = new Scanner(System.in);
        short menuChosen = in.nextShort();
        Scanner babe = new Scanner(System.in);
        String changed;
        double p;
        switch(menuChosen)
        {
            case 1:
                System.out.print("Въведете номера на напитката, името и големината:");
                changed = babe.nextLine();
                break;
            case 2:
                System.out.print("Въведете описанието на напитката:");
                changed = babe.nextLine();
                break;
            case 3:
                System.out.print("Въведете цената на купуване:");
                p = babe.nextDouble();
                changed = String.valueOf(p);
                break;
            case 4:
                System.out.print("Въведете цената на продажба;");
                p = babe.nextDouble();
                changed = String.valueOf(p);
                break;
            case 5:
                System.out.print("Въведете наличност:");
                int k = babe.nextInt();
                changed = String.valueOf(k);
                break;
            default:changed = "";
        }
        drinkArray[number-1][menuChosen-1] = changed;
        int indx = fM.seeLenght(drinkArray);
        fM.FileWrite("drink.txt",drinkArray,indx);
    }
    public void buyDrink()
    {
        String[][] drinkArray;
        drinkArray = new String[128][8];
        FileManage fM = new FileManage();
        drinkArray = fM.FileRead("drink.txt");
        int indx = fM.seeLenght(drinkArray);
        for(int i=0;i<indx;i++)
            for(int j=0;j<5;j++)
                System.out.println(drinkArray[i][j]);
        System.out.print("Въведете номера на напитката, която ще поръчате:");
        Scanner in = new Scanner(System.in);
        int numDrink = in.nextInt();
        int nowValue = Integer.valueOf(drinkArray[numDrink - 1][4]) - 1;
        drinkArray[numDrink - 1][4] = String.valueOf(nowValue);

        fM.FileWrite("drink.txt",drinkArray,indx);
        double win = Double.valueOf(drinkArray[numDrink - 1][3]) - Double.valueOf(drinkArray[numDrink - 1][2]);
        double[] winning;
        int ind = 0;
        winning = new double[16];
        winning = fM.FileReadMoney();
        winning[1] += win;
        winning[3] += win;
        fM.FileWriteMoney(winning);
    }
    public void Wastage()
    {
        System.out.print("Въведете номер на напитка:");
        Scanner in = new Scanner(System.in);
        int numberDrink = in.nextInt();
        System.out.print("Въведете брой напитки фира от този номер:");
        int cntDrink = in.nextInt();
        double[] winning;
        int ind = 0;
        winning = new double[16];
        FileManage fM = new FileManage();
        winning = fM.FileReadMoney();
        String[][] drinkArray;
        drinkArray = new String[128][8];
        drinkArray = fM.FileRead("drink.txt");
        int indx = fM.seeLenght(drinkArray);
        int lost = Integer.valueOf(drinkArray[numberDrink - 1][4])-cntDrink;
        drinkArray[numberDrink - 1][4] = String.valueOf(lost);
        double lose = cntDrink*Double.valueOf(drinkArray[numberDrink - 1][2]);
        winning[5] += lose;
        winning[7] += lose;
        winning[8] += lose;
        fM.FileWrite("drink.txt" , drinkArray , indx);
        fM.FileWriteMoney(winning);
    }
}
