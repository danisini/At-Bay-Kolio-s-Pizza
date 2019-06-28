package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManage {
    private static String newline = System.getProperty("line.separator");
    private String[][] pArray;
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
                    myWriter.write(array[i][j]);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
