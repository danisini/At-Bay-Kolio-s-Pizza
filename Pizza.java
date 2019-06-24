package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pizza extends Product {
    private String size,name;//big,medium,small
    public static String newline = System.getProperty("line.separator");
    public void newPizza()
    {
        Scanner in= new Scanner(System.in);
        System.out.print("Въведете име на пицата:");
        name=in.nextLine();
        System.out.print("Въведете големина на пицата(big/medium/small):");
        size=in.nextLine();

        Product pizza=new Product();

        String[] pizzaArray={""};
        int indx=0;
        try {
            File myObj = new File("pizza.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                pizzaArray[indx]="";
                for(int i=0;i<5;i++)
                {
                    String data = myReader.nextLine();
                    pizzaArray[indx]+=data+'\n';
                }
                indx++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String pizzaInfo=pizza.getInfo();
        try {
            File pizzaFile= new File("pizza.txt");
            FileWriter myWriter = new FileWriter(pizzaFile);
            for(int i=0;i<indx;i++)
            {
                myWriter.write(pizzaArray[i]);
            }
            myWriter.write(String.valueOf(indx)+" "+name+" "+size+pizzaInfo);//TODO next number
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void EditPizza(int number){
        //access file store everything into array
        String[] pizzaArray={""};
        int indx=0;
        try {
            File myObj = new File("pizza.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                pizzaArray[indx]="";
                for(int i=0;i<5;i++)
                {
                    String data = myReader.nextLine();
                    pizzaArray[indx]+=data+" ";
                }
                indx++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //na number element ot pizzaArray change ...
    }
    public void buyPizza()
    {
        String[] nameArray;
        nameArray= new String[128];
        Double[] prBArray={0.0};
        prBArray= new Double[128];
        Double[] prNArray={0.0};
        prNArray= new Double[128];
        Double[] winArray={0.0};
        winArray= new Double[128];
        Integer[] inHandArray={0};
        inHandArray= new Integer[128];
        String[] pizzaArray;
        pizzaArray= new String[128];
        int indx=0;
        try {
            File myObj = new File("pizza.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                pizzaArray[indx]="";
                for(int i=0;i<5;i++)
                {
                    String data = myReader.nextLine();
                    if(i==0)nameArray[indx]=data;
                    if(i==1)prBArray[indx]=Double.valueOf(data);
                    if(i==2)prNArray[indx]=Double.valueOf(data);
                    if(i==3)winArray[indx]=Double.valueOf(data);
                    if(i==4)inHandArray[indx]=Integer.valueOf(data);
                    pizzaArray[indx]+=data+" ";
                    System.out.println(data);
                }
                indx++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.print("Въведете номера на пицата, която ще поръчате:");
        Scanner in=new Scanner(System.in);
        int numPizza=in.nextInt();
        //TODO pechalba failut prn-prb
        inHandArray[numPizza]--;

        try {
            File pizzaFile= new File("pizza.txt");
            FileWriter myWriter = new FileWriter(pizzaFile);
            for(int i=0;i<indx;i++)
            {
                myWriter.write(nameArray[i]);
                myWriter.write(newline);
                myWriter.write(String.valueOf(prBArray[i]));
                myWriter.write(newline);
                myWriter.write(String.valueOf(prNArray[i]));
                myWriter.write(newline);
                myWriter.write(String.valueOf(winArray[i]));
                myWriter.write(newline);
                myWriter.write(String.valueOf(inHandArray[i]));
                myWriter.write(newline);

            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
