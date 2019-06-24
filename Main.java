package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Въведете потребителско име:");
        Scanner in=new Scanner(System.in);
        String nickname=in.nextLine();

        System.out.print("Въведете парола:");
        String password=in.nextLine();
        if(nickname.equals("admin") && nickname.equals(password))
        {
            new Admin();
        }
        else{
            new Client();
        }
    }
}
