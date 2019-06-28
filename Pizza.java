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
        int indx = seeLenght(pizzaArray);
        pizzaArray[indx][0] = String.valueOf(indx + 1) + " " + name + " " + size + newline;
        pizzaArray[indx][1] = description + newline;
        pizzaArray[indx][2] = moneyBought + newline;
        pizzaArray[indx][3] = moneySold + newline;
        pizzaArray[indx][4] = moneyInHand + newline;
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
        int indx = seeLenght(pizzaArray);
        fM.FileWrite("pizza.txt",pizzaArray,indx);
    }
    public void buyPizza()
    {
        String[][] pizzaArray;
        pizzaArray = new String[128][8];
        FileManage fM = new FileManage();
        pizzaArray = fM.FileRead("pizza.txt");
        int indx = seeLenght(pizzaArray);
        for(int i=0;i<indx;i++)
            for(int j=0;j<5;j++)
                System.out.print(pizzaArray[i][j]);
        System.out.print("Въведете номера на пицата, която ще поръчате:");
        Scanner in = new Scanner(System.in);
        int numPizza = in.nextInt();
        int nowValue = Integer.valueOf(pizzaArray[numPizza - 1][4]) - 1;
        pizzaArray[numPizza - 1][4] = String.valueOf(nowValue);

        fM.FileWrite("pizza.txt",pizzaArray,indx);
        double win = Double.valueOf(pizzaArray[numPizza - 1][3]) - Double.valueOf(pizzaArray[numPizza - 1][2]);
        Double[] winning;
        int ind = 0;
        winning = new Double[16];
        try {
            File myObj = new File("money.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                winning[ind] = Double.valueOf(data);
                ind ++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        winning[0] += win;
        winning[3] += win;
        try {
            File moneyFile = new File("money.txt");
            FileWriter myWriter = new FileWriter(moneyFile);
            for(int i = 0 ; i < 9 ; i ++)
                myWriter.write(String.valueOf(winning[i]) + newline);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void Wastage()
    {
        System.out.print("Въведете номер на пица:");
        Scanner in =new Scanner(System.in);
        int numberPizza = in.nextInt();
        System.out.print("Въведете брой пици фира от този номер:");
        int cntPizza = in.nextInt();
        Double[] winning;
        int ind = 0;
        winning = new Double[16];
        try {
            File myObj = new File("money.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                winning[ind] = Double.valueOf(data);
                ind ++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[][] pizzaArray;
        pizzaArray = new String[128][8];
        FileManage fM = new FileManage();
        pizzaArray = fM.FileRead("pizza.txt");
        int indx = seeLenght(pizzaArray);
        int lost=Integer.valueOf(pizzaArray[numberPizza-1][4])-cntPizza;
        pizzaArray[numberPizza-1][4]=String.valueOf(lost);
        double lose=cntPizza*Double.valueOf(pizzaArray[numberPizza-1][2]);
        winning[4]+=lose;
        winning[7]+=lose;
        winning[8]+=lose;

        fM.FileWrite("pizza.txt",pizzaArray,indx);
        try {
            File moneyFile = new File("money.txt");
            FileWriter myWriter = new FileWriter(moneyFile);
            for(int i = 0 ; i < 9 ; i ++)
                myWriter.write(String.valueOf(winning[i]) + newline);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}