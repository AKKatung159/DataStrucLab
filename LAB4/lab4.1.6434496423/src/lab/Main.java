package lab;

import datastr.DenseVector;
import datastr.SparseVector;

public class Main {
    public static void main(String[] args) throws Exception {
        SparseVector v1 =new SparseVector(10);
        SparseVector v2 =new SparseVector(10);
//        DenseVector v2 = new DenseVector(10);
        v1.set(0,5);v1.set(1,2);v1.set(2,9); v1.set(3,4);v1.set(4,4);v1.set(5,1); v1.set(6,5);v1.set(7,4);v1.set(8,1);
        v2.set(0,1);v2.set(4,9);v2.set(5,6); v2.set(6,5);v2.set(9,9);
        System.out.println("v1\t\t\t= "+v1);
        System.out.println("0.5 * v1\t= "+v1.multiply(0.5));
        System.out.println("v2\t\t\t= "+v2);
        System.out.println("0.5 * v2\t= "+v2.multiply(0.5));
        System.out.println("v2 + v1\t\t= "+v1.add(v2));
        System.out.println("v1 - v2\t\t= "+v1.subtract(v2));
        System.out.println("v1.v2\t\t= "+v1.dot(v2));
        System.out.println("v2.v1\t\t= "+v2.dot(v1));
        DenseVector dv1 =new DenseVector(10);
        DenseVector dv2 =new DenseVector(10);
        dv1.set(0,5);dv1.set(1,2);dv1.set(2,9);dv1.set(3,4);dv1.set(4,4);dv1.set(5,1); dv1.set(6,5);dv1.set(7,4);dv1.set(8,1);dv1.set(9,0);
        dv2.set(0,1);dv2.set(1,0);dv2.set(2,0);dv2.set(3,0);dv2.set(4,9);dv2.set(5,6); dv2.set(6,5);dv2.set(7,0);dv2.set(8,0);dv2.set(9,9);
        System.out.println("\ndv1\t\t\t= "+dv1);
        System.out.println("0.5 * dv1\t= "+dv1.multiply(0.5));
        System.out.println("dv2\t\t\t= "+dv2);
        System.out.println("0.5 * dv2\t= "+dv2.multiply(0.5));
        System.out.println("dv2 + dv1\t= "+dv1.add(dv2));
        System.out.println("dv1 - dv2\t= "+dv1.subtract(dv2));
        System.out.println("dv1.dv2\t\t= "+dv1.dot(dv2));
        System.out.println("dv2.dv1\t\t= "+dv2.dot(dv1));
    }
}