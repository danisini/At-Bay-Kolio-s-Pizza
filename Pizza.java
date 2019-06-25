package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pizza extends Product {
    private String size , name , description;//big,medium,small
    public static String newline = System.getProperty("line.separator");
    public void newPizza()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Въведете име на пицата:");
        name = in.nextLine();
        System.out.print("Въведете големина на пицата:");
        size = in.nextLine();
        System.out.print("Въведете описание на пицата:");
        description = in.nextLine();
        Product pizza = new Product();
        pizza.newOne();
        String[] pizzaArray;
        pizzaArray = new String[128];
        int indx = 0;
        try {
            File myObj = new File("pizza.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                pizzaArray[indx] = "";
                for(int i = 0 ; i < 5 ; i ++)
                {
                    String data = myReader.nextLine();
                    pizzaArray[indx] += data + newline;
                }
                indx ++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String pizzaInfo = pizza.getInfo();
        try {
            File pizzaFile = new File("pizza.txt");
            FileWriter myWriter = new FileWriter(pizzaFile);
            for(int i = 0 ; i < indx ; i ++)
            {
                myWriter.write(pizzaArray[i]);
            }
            myWriter.write(String.valueOf(indx+1)+" "+name+" "+size+newline+description+pizzaInfo);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void EditPizza(int number){
        String[][] pizzaArray;
        pizzaArray = new String [128][8];
        int indx = 0;
        try {
            File myObj = new File("pizza.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                for(int i = 0 ; i < 5 ; i ++)
                {
                    String data = myReader.nextLine();
                    pizzaArray[indx][i] = data;
                }
                indx ++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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
        try {
            File pizzaFile = new File("pizza.txt");
            FileWriter myWriter = new FileWriter(pizzaFile);
            for(int i = 0 ; i < indx ; i ++)
            {
                for(int j = 0; j < 5 ; j ++)
                    myWriter.write(pizzaArray[i][j] + newline);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void buyPizza()
    {
        String[][] pizzaArray;
        pizzaArray = new String[128][8];
        int indx = 0;
        try {
            File myObj = new File("pizza.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                for(int i = 0 ; i < 5 ; i ++)
                {
                    String data = myReader.nextLine();
                    pizzaArray[indx][i] = data;
                    System.out.println(data);
                }
                indx ++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.print("Въведете номера на пицата, която ще поръчате:");
        Scanner in = new Scanner(System.in);
        int numPizza = in.nextInt();
        int nowValue = Integer.valueOf(pizzaArray[numPizza - 1][4]) - 1;
        pizzaArray[numPizza - 1][4] = String.valueOf(nowValue);
        try {
            File pizzaFile = new File("pizza.txt");
            FileWriter myWriter = new FileWriter(pizzaFile);
            for(int i = 0 ; i < indx ; i++)
                for(int j = 0 ; j < 5 ; j ++)
                    myWriter.write(pizzaArray[i][j] + newline);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        double win = Double.valueOf(pizzaArray[numPizza - 1][3]) - Double.valueOf(pizzaArray[numPizza - 1][2]);
        Double[] winning;
        int ind = 0;
        winning = new Double[8];
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
            for(int i = 0 ; i < 4 ; i ++)
                myWriter.write(String.valueOf(winning[i]) + newline);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
