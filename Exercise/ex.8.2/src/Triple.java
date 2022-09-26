import java.util.*;

public class Triple {
    private int num1,num2,num3;
    public Triple(int num1,int num2,int num3){
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(num1);a.add(num2);a.add(num3);
        Collections.sort(a);
        this.num1 = a.get(0);
        this.num2 = a.get(1);
        this.num3 = a.get(2);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple triple = (Triple) o;
        return num1 == triple.num1 && num2 == triple.num2 && num3 == triple.num3;
    }
    public int hashCode() {
        return (num1*3+num2*5+num3*7);
    }

    @Override
    public String toString() {
        return
                "num 1 = " + num1 +
                "\nnum 2 = " + num2 +
                "\nnum 3 = " + num3;
    }
}
