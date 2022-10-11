import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class BinaryHeap implements PriortyQueue {
    private Object[] elementData;
    private int size;

    public BinaryHeap(int cap){
        elementData = new Object[cap];
    }

    public BinaryHeap(Object[] d){
        elementData = (Object[]) d.clone();
        size = d.length;
        for (int i=size-1; i>=0; i--) fixDown(i);
    }

    public boolean isEmpty() {
        return size==0 ;
    }

    public int size() {
        return size;
    }


    public Object peek(){
        if (isEmpty()) throw new NoSuchElementException();
        return elementData[0];
    }

    public void enqueue(Object e) {
        ensureCapacity(size+1);
        elementData[size] = e;
        fixUp(size++);
    }
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2*elementData.length);
            Object[] arr = new Object[s];
            for(int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }

    private  void fixUp(int k) {
        while (k>0){
            int p = (k-1)/2;
            if (!greaterThan(k,p) ) break;
            swap(k,p);
            k=p;
        }
    }

    boolean greaterThan(int i ,int j){
        Comparable e = (Comparable) elementData[i];
        return e.compareTo(elementData[j]) > 0;
    }

    void swap(int i,int j ){
        Object t = elementData[i];
        elementData[i] = elementData[j];
        elementData[j] = t;
    }

    public Object dequeue() {
        Object max = peek() ;
        elementData[0] = elementData[--size];
        elementData[size] = null;
        if (size > 1 ) fixDown(0);
        return max;
    }

    private void fixDown(int k) {
        int c;
        while (( c = 2*k+1) < size){
            if (c+1 < size && greaterThan(c+1,c)) c++;
            if (!greaterThan(c,k)) break;
            swap(k,c);
            k=c;
        }
    }


    //วิธีที่2
    /*public static  Object select(Object[] a , int k){
        PriortyQueue h = new BinaryMinHeap(a.length);
        for(int i=0;i <k-1;i++)
            h.dequeue();
        return h.dequeue();
    }*/

    //วิธีที่3
    public static Object select(Object[] a , int k){
        PriortyQueue h = new BinaryMaxHeap(k);
        int j=0;
        for (; j<k; j++) h.enqueue(a[j]);
        for (; j<a.length; j++){
            Comparable e = (Comparable) a[j];
            if (e.compareTo(h.peek()) < 0 ){
                h.dequeue();
                h.enqueue(e);
            }
        }
        return h.peek();
    }
}
