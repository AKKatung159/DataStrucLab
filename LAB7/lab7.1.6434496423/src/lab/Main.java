package lab;

import datastr.SeparateChainingHashMap;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/lab/register.csv"));
        SeparateChainingHashMap schashMap = new SeparateChainingHashMap(12);
        while (sc.hasNext()) {

            String[] line = sc.nextLine().split(",");
            if (schashMap.containsKey(new Student(line[0]))) {
                ((ArrayList) schashMap.get(new Student(line[0]))).add(new CourseGrade(line[3], line[4], Integer.valueOf(line[5]), line[6], Double.valueOf(line[7]), Double.valueOf(line[8])));
            } else {
                ArrayList a = new ArrayList<>();
                a.add(new CourseGrade(line[3], line[4], Integer.valueOf(line[5]), line[6], Double.valueOf(line[7]), Double.valueOf(line[8])));
                schashMap.put(new Student(line[0], line[1], line[2]), a);
            }
        }
        sc.close();
        System.out.println(schashMap);
    }
}