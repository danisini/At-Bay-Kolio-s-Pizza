package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pizza extends Product {
    private String size , name ,description;//big,medium,small
    public static String newline = System.getProperty("line.separator");
    private String[] pArray;
    public void newPizza()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Въведете име на пицата:");
        name = in.nextLine();
        System.out.print("Въведете големина на пицата:");
        size = in.nextLine();
        System.out.print("Въведете описание на пицата:");
        description = in.nextLine();
        String[][] pizzaArray;
        pizzaArray = new String[128][8];
        FileManage fM = new FileManage();
        pizzaArray = fM.FileRead("pizza.txt");
        Product pizza = new Product();
        pizza.newOne();
        String moneyBought = pizza.getMoneyBought();
        String moneySold = pizza.getMoneySold();
        String moneyInHand = pizza.getInHand();
        int indx = fM.seeLenght(pizzaArray);
        pizzaArray[indx][0] = String.valueOf(indx + 1) + " " + name + " " + size;
        pizzaArray[indx][1] = description;
        pizzaArray[indx][2] = moneyBought;
        pizzaArray[indx][3] = moneySold;
        pizzaArray[indx][4] = moneyInHand;
        indx ++;
        fM.FileWrite("pizza.txt" , pizzaArray , indx);
    }
    public void EditPizza(int number){
        String[][] pizzaArray;
        pizzaArray = new String [128][8];
        FileManage fM = new FileManage();
        pizzaArray = fM.FileRead("pizza.txt");
        System.out.print("За да смените името и големината-въведете 1, за описание-2, за цена на купуване-3, за цена на продажба-4, за наличност-5:");
        Scanner in = new Scanner(System.in);
        short menuChosen = in.nextShort();
        Scanner babe = new Scanner(System.in);
        String changed;
        double p;
        switch(menuChosen)
        {
            case 1:
                System.out.print("Въведете номера на пицата, името и големината:");
                changed = babe.nextLine();
                break;
            case 2:
                System.out.print("Въведете описанието на пицата:");
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
        pizzaArray[number-1][menuChosen-1] = changed;
        int indx = fM.seeLenght(pizzaArray);
        fM.FileWrite("pizza.txt",pizzaArray,indx);
    }
    public void buyPizza()
    {
        String[][] pizzaArray;
        pizzaArray = new String[128][8];
        FileManage fM = new FileManage();
        pizzaArray = fM.FileRead("pizza.txt");
        int indx = fM.seeLenght(pizzaArray);
        for(int i=0;i<indx;i++)
            for(int j=0;j<5;j++)
                System.out.println(pizzaArray[i][j]);
        System.out.print("Въведете номера на пицата, която ще поръчате:");
        Scanner in = new Scanner(System.in);
        int numPizza = in.nextInt();
        int nowValue = Integer.valueOf(pizzaArray[numPizza - 1][4]) - 1;
        pizzaArray[numPizza - 1][4] = String.valueOf(nowValue);

        fM.FileWrite("pizza.txt",pizzaArray,indx);
        double win = Double.valueOf(pizzaArray[numPizza - 1][3]) - Double.valueOf(pizzaArray[numPizza - 1][2]);
        double[] winning;
        int ind = 0;
        winning = new double[16];
        winning = fM.FileReadMoney();
        winning[0] += win;
        winning[3] += win;
        fM.FileWriteMoney(winning);
    }
    public void Wastage()
    {
        System.out.print("Въведете номер на пица:");
        Scanner in = new Scanner(System.in);
        int numberPizza = in.nextInt();
        System.out.print("Въведете брой пици фира от този номер:");
        int cntPizza = in.nextInt();
        double[] winning;
        int ind = 0;
        winning = new double[16];
        FileManage fM = new FileManage();
        winning = fM.FileReadMoney();
        String[][] pizzaArray;
        pizzaArray = new String[128][8];
        pizzaArray = fM.FileRead("pizza.txt");
        int indx = fM.seeLenght(pizzaArray);
        int lost = Integer.valueOf(pizzaArray[numberPizza - 1][4])-cntPizza;
        pizzaArray[numberPizza - 1][4] = String.valueOf(lost);
        double lose = cntPizza*Double.valueOf(pizzaArray[numberPizza - 1][2]);
        winning[4] += lose;
        winning[7] += lose;
        winning[8] += lose;
        fM.FileWrite("pizza.txt" , pizzaArray , indx);
        fM.FileWriteMoney(winning);
    }
}