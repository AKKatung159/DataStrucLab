package lab;

import datastr.ArrayStack;

public class Main {
    public static void main(String[] args) {
        System.out.println("solution is "+reverse("12345")+"\n");
    }
    public static ArrayStack stack=new ArrayStack();
    public static String reverse(String s) {
        String backR ="";
        String back = s.substring(1,s.length());
        String y="";
        backR += s.substring(0,1);
        stack.push(new ARI(s,"",""));
        System.out.print("Call reverse(\""+s+"\")\n=== BOTTOM OF STACK ===");
        System.out.println(stack.toString());
        ARI ari = (ARI) stack.peek();
        ari.setBack(back);
        if (s.length()>1) {
            y=reverse(back);
            backR=y+backR;
            stack.pop();
            System.out.print("Return from reverse(\""+s+"\")\n=== BOTTOM OF STACK ===");
            ari = (ARI) stack.peek();
            ari.setBackR(y);
            System.out.println(stack.toString());
            return backR;
        }
        else {
            System.out.print("Return from reverse(\""+s+"\")\n=== BOTTOM OF STACK ===");
            System.out.println(stack.toString());
            return backR;
        }
    }

}
