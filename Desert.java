package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Desert extends Product {
    private String size , name ,description;//big,medium,small
    public static String newline = System.getProperty("line.separator");
    private String[] pArray;
    private int seeLenght(String[][] array)
    {
        int ind = 0;
        for(int i = 0 ; i < 128 ; i ++)
        {
            if(array[i][0] == null)
            {
                ind = i;
                break;
            }
        }
        return ind;
    }
    public void newDesert()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Въведете име на десерта:");
        name = in.nextLine();
        System.out.print("Въведете големина на десерта:");
        size = in.nextLine();
        System.out.print("Въведете описание на десерта:");
        description = in.nextLine();
        String[][] desertArray;
        desertArray = new String[128][8];
        FileManage fM = new FileManage();
        desertArray = fM.FileRead("desert.txt");
        Product desert = new Product();
        desert.newOne();
        String moneyBought = desert.getMoneyBought();
        String moneySold = desert.getMoneySold();
        String moneyInHand = desert.getInHand();
        int indx = seeLenght(desertArray);
        desertArray[indx][0] = String.valueOf(indx + 1) + " " + name + " " + size;
        desertArray[indx][1] = description;
        desertArray[indx][2] = moneyBought;
        desertArray[indx][3] = moneySold;
        desertArray[indx][4] = moneyInHand;
        indx ++;
        fM.FileWrite("desert.txt" , desertArray , indx);
    }
    public void EditDesert(int number){
        String[][] desertArray;
        desertArray = new String [128][8];
        FileManage fM = new FileManage();
        desertArray = fM.FileRead("desert.txt");
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
        desertArray[number-1][menuChosen-1] = changed;
        int indx = seeLenght(desertArray);
        fM.FileWrite("desert.txt",desertArray,indx);
    }
    public void buyDesert()
    {
        String[][] desertArray;
        desertArray = new String[128][8];
        FileManage fM = new FileManage();
        desertArray = fM.FileRead("desert.txt");
        int indx = seeLenght(desertArray);
        for(int i=0;i<indx;i++)
            for(int j=0;j<5;j++)
                System.out.println(desertArray[i][j]);
        System.out.print("Въведете номера на десерта, която ще поръчате:");
        Scanner in = new Scanner(System.in);
        int numDesert = in.nextInt();
        int nowValue = Integer.valueOf(desertArray[numDesert - 1][4]) - 1;
        desertArray[numDesert - 1][4] = String.valueOf(nowValue);

        fM.FileWrite("desert.txt",desertArray,indx);
        double win = Double.valueOf(desertArray[numDesert - 1][3]) - Double.valueOf(desertArray[numDesert - 1][2]);
        double[] winning;
        int ind = 0;
        winning = new double[16];
        winning = fM.FileReadMoney();
        winning[2] += win;
        winning[3] += win;
        fM.FileWriteMoney(winning);
    }
    public void Wastage()
    {
        System.out.print("Въведете номер на десерта:");
        Scanner in = new Scanner(System.in);
        int numberDesert = in.nextInt();
        System.out.print("Въведете брой десерти фира от този номер:");
        int cntDesert = in.nextInt();
        double[] winning;
        int ind = 0;
        winning = new double[16];
        FileManage fM = new FileManage();
        winning = fM.FileReadMoney();
        String[][] desertArray;
        desertArray = new String[128][8];
        desertArray = fM.FileRead("desert.txt");
        int indx = seeLenght(desertArray);
        int lost = Integer.valueOf(desertArray[numberDesert - 1][4])-cntDesert;
        desertArray[numberDesert - 1][4] = String.valueOf(lost);
        double lose = cntDesert*Double.valueOf(desertArray[numberDesert - 1][2]);
        winning[6] += lose;
        winning[7] += lose;
        winning[8] += lose;
        fM.FileWrite("desert.txt" , desertArray , indx);
        fM.FileWriteMoney(winning);
    }
}
