package lab;

import datastr.DenseMatrix;
import datastr.DenseVector;
import datastr.SparseMatrix;
import datastr.SparseVector;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        SparseMatrix m1 = new SparseMatrix(5,10);
        SparseMatrix m2 = new SparseMatrix(10,2);
        SparseMatrix m3 = new SparseMatrix(5,10);

        Random r =new Random();
        for (int i = 0; i < m1.numRows(); i++) {
            for (int j = 0; j < m1.numCols(); j++) {
                m1.set(i,j,r.nextInt(5));
            }
        }
        for (int i = 0; i < m2.numRows(); i++) {
            for (int j = 0; j < m2.numCols(); j++) {
                m2.set(i,j,r.nextInt(5));
            }
        }
        for (int i = 0; i < m3.numRows(); i++) {
            for (int j = 0; j < m3.numCols(); j++) {
                m3.set(i,j,r.nextInt(5));
            }
        }

        System.out.println("matrix m1 =\n"+m1+"============================");
        System.out.println("matrix m2 =\n"+m2+"============================");
        System.out.println("matrix m3 =\n"+m3+"============================");
        System.out.println("m1 * m2 =\n"+m1.multiply(m2)+"============================");
        System.out.println("m1 + m3 =\n"+m1.add(m3)+"============================");

        DenseMatrix m4 = new DenseMatrix(5,10);
        DenseMatrix m5 = new DenseMatrix(10,2);
        DenseMatrix m6 = new DenseMatrix(5,10);

        for (int i = 0; i < m4.numRows(); i++) {
            for (int j = 0; j < m4.numCols(); j++) {
                m4.set(i,j,r.nextInt(5));
            }
        }
        for (int i = 0; i < m5.numRows(); i++) {
            for (int j = 0; j < m5.numCols(); j++) {
                m5.set(i,j,r.nextInt(5));
            }
        }
        for (int i = 0; i < m6.numRows(); i++) {
            for (int j = 0; j < m6.numCols(); j++) {
                m6.set(i,j,r.nextInt(5));
            }
        }

        System.out.println("matrix m4 =\n"+m4+"============================");
        System.out.println("matrix m5 =\n"+m5+"============================");
        System.out.println("matrix m6 =\n"+m6+"============================");
        System.out.println("m4 * m5 =\n"+m4.multiply(m5)+"============================");
        System.out.println("m4 + m6 =\n"+m4.add(m6)+"============================");
    }
}