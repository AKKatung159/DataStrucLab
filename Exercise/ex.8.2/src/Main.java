import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r=new Random();
        int k= r.nextInt(10,21);
        System.out.println("K = "+k);
        HashMap hashMap=new HashMap<>();
        int num1 = r.nextInt(k);
        int num2 = r.nextInt(k-num1);
        int num3 = k-num1-num2;
        hashMap.put(k,new Triple(num1,num2,num3));
        System.out.println(hashMap.get(k));
        System.out.println(new Triple(1,2,3).equals(new Triple(3,2,1)));
        System.out.println(new Triple(1,2,3).hashCode());
        System.out.println(new Triple(3,2,1).hashCode());
    }
}