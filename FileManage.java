package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManage {
    private static String newline = System.getProperty("line.separator");
    private String[][] pArray;
    public int seeLenght(String[][] array)
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
    public String[][] FileRead(String pathName)
    {
        int indx = 0;
        pArray = new String[128][8];
        try {
            File myObj = new File(pathName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                for(int i = 0 ; i < 5 ; i ++)
                {
                    String data = myReader.nextLine();
                    pArray[indx][i] = data;
                }
                indx ++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return pArray;
    }
    public void FileWrite(String pathName,String[][] array,int indx)
    {
        try {
            File pizzaFile = new File(pathName);
            FileWriter myWriter = new FileWriter(pizzaFile);
            for(int i = 0 ; i < indx ; i ++)
                for(int j = 0; j < 5 ; j ++)
                    myWriter.write(array[i][j]+newline);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public double[] FileReadMoney()
    {
        double[] money;
        money = new double[16];
        int ind = 0;
        try {
            File myObj = new File("money.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                money[ind] = Double.valueOf(data);
                ind ++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return money;
    }
    public void FileWriteMoney(double[] array)
    {
        try {
            File moneyFile = new File("money.txt");
            FileWriter myWriter = new FileWriter(moneyFile);
            for(int i = 0 ; i < 9 ; i ++)
                myWriter.write(String.valueOf(array[i]) + newline);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
