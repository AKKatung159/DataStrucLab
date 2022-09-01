package lab;

import datastr.LinkedCollectionWithDup;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedCollectionWithDup lcd=new LinkedCollectionWithDup();
        System.out.println("Add or remove or stop?");
        String com = input.nextLine().trim();
        while (!com.equals("stop")){
            if(com.equals("add")){
                System.out.println("add num : ");
                lcd.add(Integer.parseInt(input.nextLine()));
            } else if (com.equals("remove")) {
                System.out.println("remove num : ");
                lcd.remove(Integer.parseInt(input.nextLine()));
            }else {
                System.out.println("Invalid command.");
            }


            System.out.println("Add or delete or stop?");
            com = input.nextLine().trim();
        }

        System.out.println("\n"+lcd);
    }
}