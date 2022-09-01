package lab;

import datastr.ArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList a = new ArrayList(100);
        for (int i = 0; i < 100; i++) {
            a.add(i);
        }
        System.out.println("Initial list");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i));
            if (i < a.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\nReverse");
        a.reverse();
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i));
            if (i < a.size() - 1) {
                System.out.print(", ");
            }
        }
        Random r = new Random();
        int m = r.nextInt(100);
        int n = r.nextInt(100);
        if (m < n) {
            a.removeRange(m, n);
        } else {
            a.removeRange(n, m);
        }
        System.out.println("\nRemove " + m + ", " + n);
        System.out.println(a);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i));
            if (i < a.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}