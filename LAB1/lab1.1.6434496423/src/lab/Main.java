package lab;
import datastr.ArrayCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc,input;
        input = new Scanner(System.in);
        ArrayCollection StudentBox = new ArrayCollection(2);
        try {
            sc = new Scanner(new File("src/lab/student.csv"));
            while (sc.hasNextLine()){
                String[] line= sc.nextLine().split(",");
                StudentBox.add(new Student(line[0],line[1],line[2],Float.parseFloat(line[3])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Add or delete or stop?");
        String com = input.nextLine().trim();
        while (!com.equals("stop")){
            if(com.equals("add")){
                //String[] ipline = (input.nextLine().split(" "));
                Student st = new Student(input.next(), input.next(),input.next(),input.nextFloat()); //ipline[0],ipline[1],ipline[2],Float.parseFloat(ipline[3])
                input.nextLine();
                if(StudentBox.contains(st)){
                    StudentBox.remove(st);
                    StudentBox.add(st);
                    System.out.println("add new record.");
                }
                else {
                    System.out.println("add new record.");
                    StudentBox.add(st);
                }
            } else if (com.equals("delete")) {
                String ipline = input.next();
                input.nextLine();
                Student st = new Student(ipline);
                if(StudentBox.contains(st)){
                    StudentBox.remove(st);
                    System.out.println("remove a record.");
                }
                else {
                    System.out.println("don't have a record.");
                }
            }else {
                System.out.println("Invalid command.");
            }


            System.out.println("Add or delete or stop?");
            com = input.nextLine().trim();
        }

        PrintWriter out =new PrintWriter("studentNew.csv");
        for (int i = 0; i <StudentBox.size(); i++) {
            out.write((StudentBox.toArray()[i]).toString()+"\n");
        }
        out.close();

        System.out.println("Written to studentNew.csv");
    }
}