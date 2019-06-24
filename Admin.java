package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class Admin {
    public Admin() {
        System.out.print("Въведи 1 за списък с продукти с наличност<5,2 за разглеждане на продукти:");
        Scanner in = new Scanner(System.in);
        int typeIn = in.nextInt();
        if (typeIn == 1) {//list
            try {
                File myObj = new File("pizza.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String name = myReader.nextLine();
                    String priceB= myReader.nextLine();
                    String priceN = myReader.nextLine();
                    String diff = myReader.nextLine();
                    String inHand = myReader.nextLine();
                    if(Integer.valueOf(inHand)<5)System.out.println(name);
                }
                myReader.close();

                myObj = new File("drink.txt");
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String name = myReader.nextLine();
                    String priceB= myReader.nextLine();
                    String priceN = myReader.nextLine();
                    String diff = myReader.nextLine();
                    String inHand = myReader.nextLine();
                    if(Integer.valueOf(inHand)<5)System.out.println(name);
                }
                myReader.close();
                myObj = new File("desert.txt");
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String name = myReader.nextLine();
                    String priceB= myReader.nextLine();
                    String priceN = myReader.nextLine();
                    String diff = myReader.nextLine();
                    String inHand = myReader.nextLine();
                    if(Integer.valueOf(inHand)<5)System.out.println(name);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else if(typeIn==2)
        {
            System.out.print("За пици-въведете 1, за напитки-2, за десерти-3:");
            int typeProduct=in.nextInt();
            if(typeProduct==1)
            {
                System.out.println("Ако искате да въведете нова пица-въведете 0,за редактиране-веведете номера на пицата:");
                try {
                    File myObj = new File("pizza.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                //
                int pizzaNumber=in.nextInt();
                if(pizzaNumber==0)
                {
                    Pizza pizza=new Pizza();
                    pizza.newPizza();
                }
                else
                {
                    Pizza now=new Pizza();
                    now.EditPizza(pizzaNumber);
                }
            }
            else if(typeProduct==2)
            {
                System.out.println("Ако искате да въведете нова напитка-въведете 0,за редактиране-веведете номера на напитката:");
                try {
                    File myObj = new File("drink.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                //
                int drinkNumber=in.nextInt();
                if(drinkNumber==0)
                {
                    new Drink();
                }
                else
                {
                    Drink now=new Drink();
                    now.EditDrink(drinkNumber);
                }
            }
            else if(typeProduct==3)
            {
                System.out.println("Ако искате да въведете нов десерт-въведете 0,за редактиране-веведете номера на десерта:");
                try {
                    File myObj = new File("desert.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                //
                int desertNumber=in.nextInt();
                if(desertNumber==0)
                {
                    new Desert();
                }
                else
                {
                    Desert now=new Desert();
                    now.EditDesert(desertNumber);
                }
            }
        }
    }
}
