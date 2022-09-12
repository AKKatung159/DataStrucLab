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
        backR += s.substring(0,1);
        stack.push(new ARI("c",s,back,backR));
        System.out.println("CALL");
        System.out.println(stack.toString());
        if (s.length()>1) {
            String y=reverse(back)+backR;
            stack.pop();
            System.out.println("RETURN");
            System.out.println(stack.toString());
            return y;
        }
        else {
            System.out.println("RETURN222");
            System.out.println(stack.toString());
            return backR;
        }
    }

}
