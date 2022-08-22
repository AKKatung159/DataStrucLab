package lab;
import datastr.LinkedCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1,sc2;
        LinkedCollection StudentBox = new LinkedCollection();
        LinkedCollection WithdrawBox = new LinkedCollection();
        try {
            sc1 = new Scanner(new File("src/lab/student.csv"));
            sc2 = new Scanner(new File("src/lab/withdraw.csv"));
            while (sc1.hasNextLine()){
                String[] line= sc1.nextLine().split(",");
                StudentBox.add(new Student(line[0],line[1],line[2],Float.parseFloat(line[3])));
            }
            while (sc2.hasNextLine()){
                String[] line= sc2.nextLine().split(",");
                WithdrawBox.add(new Student(line[0],line[1],line[2],Float.parseFloat(line[3])));
            }
            sc1.close();
            sc2.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        if(StudentBox.containsDup()){
            System.out.println("Duplicate student in file. Removed.\n");
            StudentBox.removeDup();
        }
        else {
            System.out.println("No duplicate student.\n");
        }
        if(WithdrawBox.containsDup()){
            System.out.println("Duplicate withdraw in file. Removed.\n");
            WithdrawBox.removeDup();
        }
        else {
            System.out.println("No duplicate withdraw.\n");
        }
        if(StudentBox.equals(WithdrawBox)){
            System.out.println("All withdraw ("+StudentBox.size()+")");
            for (int i = 0; i < StudentBox.size(); i++) {
                System.out.println(StudentBox.toArray()[i]);
            }
        }
        else {
            for (int i = 0; i < WithdrawBox.size(); i++) {
            StudentBox.removeAll(WithdrawBox.toArray()[i]);
        }
            System.out.println("All registered ("+StudentBox.size()+")");
            for (int i = 0; i < StudentBox.size(); i++) {
                System.out.println(StudentBox.toArray()[i]);
            }

            System.out.println("\nAll withdrew ("+WithdrawBox.size()+")");
            for (int i = 0; i < WithdrawBox.size(); i++) {
                System.out.println(WithdrawBox.toArray()[i]);
            }

        }
    }
}