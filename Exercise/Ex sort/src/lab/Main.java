package lab;

import datastr.ArrayList;
import datastr.SinglyLinkedList;
import datastr.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll =new LinkedList();
        ll.add(5);ll.add(3);ll.add(6);ll.add(10);ll.add(1);ll.add(15);ll.add(2);
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.toArray()[i]);
        }
        ll.sorted();
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.toArray()[i]);
        }
    }
}