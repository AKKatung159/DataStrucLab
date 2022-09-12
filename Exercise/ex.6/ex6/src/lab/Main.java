package lab;

import datastr.ArrayStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter your operation : ");
        String[] line =sc.nextLine().split(" ");
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < line.length; i++) {
            if(line[i].equals("+")||line[i].equals("-")||line[i].equals("*")||line[i].equals("/")){
                switch(line[i]) {
                    case "+":
                        int answer = ((int) stack.pop()+(int) stack.pop());
                        stack.push(answer);
                        System.out.println("answer : "+answer);
                        break;
                    case "-":
                        int a=(int) stack.pop();
                        int b=(int) stack.pop();
                        answer = (b-a);
                        stack.push(answer);
                        System.out.println("answer : "+answer);
                        break;
                    case "*":
                        answer = ((int) stack.pop()*(int) stack.pop());
                        stack.push(answer);
                        System.out.println("answer : "+answer);
                        break;
                    case "/":
                        a=(int) stack.pop();
                        b=(int) stack.pop();
                        answer = (b/a);
                        stack.push(answer);
                        System.out.println("answer : "+answer);
                        break;
                    default:
                }
            }
            else {
                stack.push(Integer.parseInt(line[i]));
            }
        }
    }
}