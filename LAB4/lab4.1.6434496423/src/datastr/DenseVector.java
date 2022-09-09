package datastr;

public class DenseVector implements Vector{
    private int length;
    private double[] num;
    public DenseVector(int length) {
        num = new double[length];
        this.length = length;
    }
    public int length() {
        return length;
    }
    public double magnitude() {
        int ans=0;
        for (int i = 0; i < length; i++) {
            ans+=(num[i]*num[i]);
        }
        return (Math.sqrt(ans));
    }
    public double get(int index) {
        if (index<=length){
            return num[index];
        }
        return 0;
    }
    public void set(int index, double value) {
        if (index <= length) {
            num[index] = value;
        }else {
            ensureCapacity(length+1);
            num[index]=value;
        }
    }
    public Vector add(Vector v) throws Exception{
        if(v.length()!=length){
            throw new Exception("Invalid vector dimension.");
        }

        DenseVector v1 = this;
        Vector v3 = new DenseVector(v1.length());
        for (int i=0; i<length; i++) {
            v3.set(i,this.get(i)+v.get(i));
        }
        return v3;
    }

    public Vector subtract(Vector v) throws Exception {
        if(v.length()!=length){
            throw new Exception("Invalid vector dimension.");
        }

        DenseVector v1 = this;
        Vector v3 = new DenseVector(v1.length());
        for (int i=0; i<length; i++) {
            v3.set(i,this.get(i)-v.get(i));
        }
        return v3;
    }
    public double dot(Vector v2) {
        double r = 0;
        if (v2 instanceof DenseVector) {
            DenseVector v1 = this;
            for (int i = 0; i < v1.length(); i++) {
                r += v1.get(i) * v2.get(i);
            }
        } else if (v2 instanceof SparseVector) {
            DenseVector v1 = this;
            DenseVector v = (DenseVector) v2;
            int i1 = 0, i2 = 0;
            while (i1 < v1.length && i2 < v.length) {
                double e1 = v1.num[i1];
                double e2 = v.num[i2];
                if (i1 < i2) i1++;
                else if (i1 > i2) i2++;
                else {
                    r += e1 * e2;
                    i1++;
                    i2++;
                }
            }
        }
        return r;
    }
    public Vector add(DenseVector v2) {
        DenseVector v1 = this;
        DenseVector v3 = new DenseVector(v1.length());
        for (int i=0; i<v3.length(); i++) {
            v3.set(i,v1.get(i)+v2.get(i));
        }
        return v3;
    }
    public Vector multiply(double c) {
        DenseVector v = new DenseVector(this.length);
        for (int i=0; i<length; i++) {
            v.set(i,get(i)*c);
        }
        return v;
    }
    private void ensureCapacity(int capacity) {
        if (capacity > length) {
            int s = Math.max(capacity, 2*length);
            double[] arr = new double[s];
            for(int i = 0; i < length; i++)
                arr[i] = num[i];
            num = arr;
        }
    }
    public String toString() {
        String ans="[ ";
        for (int i = 0; i < length; i++) {
            ans+=get(i)+" ";
        }
        ans+=" ]";
        return ans;
    }
}