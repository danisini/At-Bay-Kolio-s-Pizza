package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Desert extends Product {
    private String name;//big,medium,small
    public Desert(){
        Scanner in= new Scanner(System.in);
        System.out.print("Въведете име на десерта:");
        name=in.nextLine();
        Product desert=new Product();
        String desertInfo=desert.getInfo();
        try {
            File desertFile= new File("desert.txt");
            FileWriter myWriter = new FileWriter(desertFile);
            myWriter.write(String.valueOf(desertFile.length()/5)+" "+name+" "+desertInfo);//TODO next number
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public void EditDesert(int number){
        //access file store everything into array
        int desertArray;
        //na number element ot pizzaArray change ...
    }
}
