package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Drink extends Product {
    private String size,name;//big,medium,small
    public Drink(){
        Scanner in= new Scanner(System.in);
        System.out.print("Въведете име на напитката:");
        name=in.nextLine();
        System.out.print("Въведете големина на напитката(big/medium/small):");
        size=in.nextLine();
        Product drink=new Product();
        String drinkInfo=drink.getInfo();
        try {
            File drinkFile= new File("drink.txt");
            FileWriter myWriter = new FileWriter(drinkFile);
            myWriter.write(String.valueOf(drinkFile.length()/5)+" "+name+" "+size+drinkInfo);//TODO next number
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public void EditDrink(int number){
        //access file store everything into array
        int drinkArray;
        //na number element ot pizzaArray change ...
    }
}
