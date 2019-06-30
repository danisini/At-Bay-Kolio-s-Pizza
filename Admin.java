package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class Admin {
    public Admin() {
        System.out.print("Въведи 1 за разглеждане на продукти, 2 за списък с продукти с наличност по-малка от 5:");
        Scanner in = new Scanner(System.in);
        int typeIn = in.nextInt();
        if(typeIn == 1)
        {
            System.out.print("За пици-въведете 1, за напитки-2, за десерти-3:");
            int typeProduct = in.nextInt();
            if(typeProduct == 1) {
                System.out.println("Ако искате да въведете нова пица-въведете 0,за редактиране-веведете номера на пицата,за отблеязване на фира-въведете -1:");
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
                int pizzaNumber = in.nextInt();
                if (pizzaNumber == -1)
                {
                    Pizza pizza = new Pizza();
                    pizza.Wastage();
                }
                else
                if(pizzaNumber == 0)
                {
                    Pizza pizza = new Pizza();
                    pizza.newPizza();
                }
                else
                {
                    Pizza now = new Pizza();
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
                if (drinkNumber == -1)
                {
                    Drink dr = new Drink();
                    dr.Wastage();
                }
                else
                if(drinkNumber == 0)
                {
                    Drink dr = new Drink();
                    dr.newDrink();
                }
                else
                {
                    Drink dr = new Drink();
                    dr.EditDrink(drinkNumber);
                }
            }
            else if(typeProduct == 3) {
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
                int desertNumber = in.nextInt();
                if (desertNumber == -1) {
                    Desert de = new Desert();
                    de.Wastage();
                } else if (desertNumber == 0) {
                    Desert de = new Desert();
                    de.newDesert();
                } else {
                    Desert de = new Desert();
                    de.EditDesert(desertNumber);
                }
            }
        }
        else if(typeIn == 2)
        {
            FileManage fM = new FileManage();
            String[][] array;
            int size;
            array = fM.FileRead("pizza.txt");
            size = fM.seeLenght(array);
            for(int i = 0 ; i < size ; i ++)
            {
                if(Integer.valueOf(array[i][4])<5)
                    System.out.println(array[i][0]);
            }
            array = fM.FileRead("drink.txt");
            size = fM.seeLenght(array);
            for(int i = 0 ; i < size ; i ++)
            {
                if(Integer.valueOf(array[i][4])<5)
                    System.out.println(array[i][0]);
            }
            array = fM.FileRead("desert.txt");
            size = fM.seeLenght(array);
            for(int i = 0 ; i < size ; i ++)
            {
                if(Integer.valueOf(array[i][4])<5)
                    System.out.println(array[i][0]);
            }
        }
    }
}
