import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc =new Scanner(new File("src/register.csv"));
        Scanner input =new Scanner(System.in);
        HashMap hashMap =new HashMap<>();
        while (sc.hasNext()){
            String[] line = sc.nextLine().split(",");
            if (hashMap.containsKey(new Student(line[0]))){
                ((ArrayList) hashMap.get(new Student(line[0]))).add(new CourseGrade(line[3],line[4],Integer.valueOf(line[5]),line[6],Double.valueOf(line[7]),Double.valueOf(line[8])));
            }else {
                ArrayList a= new ArrayList<>();
                a.add(new CourseGrade(line[3],line[4],Integer.valueOf(line[5]),line[6],Double.valueOf(line[7]),Double.valueOf(line[8])));
                hashMap.put(new Student(line[0],line[1],line[2]),a);
            }
        }
        sc.close();
        System.out.print("Enter studentID : ");
        String search = input.nextLine();
        for (int i = 0; i < ((ArrayList )hashMap.get(new Student(search))).size(); i++) {
            System.out.println(((ArrayList )hashMap.get(new Student(search))).get(i));
        }

    }
}