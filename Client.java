package com.company;
import java.util.Scanner;

public class Client {
    public Client() {
        System.out.print("За пица въведете 1, за напитки-2, за десерт-3:");
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        if (type == 1) {
            Pizza p=new Pizza();
            p.buyPizza();
        } else if (type == 2) {

        } else if (type == 3) {

        }
    }
}
