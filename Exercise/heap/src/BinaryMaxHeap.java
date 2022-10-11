import java.util.NoSuchElementException;

public class BinaryMaxHeap implements PriortyQueue {
    private Object[] elementData;
    private int size;

    public BinaryMaxHeap(int cap) {
        elementData = new Object[cap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public Object peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return elementData[0];
    }

    public void enqueue(Object e) {
        ensureCapacity(size + 1);
        elementData[size] = e;
        fixUp(size++);
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2 * elementData.length);
            Object[] arr = new Object[s];
            for (int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }

    private void fixUp(int k) {
        while (k > 0) {
            int p = (k - 1) / 2;
            if (!greaterThan(k, p)) break;
            swap(k, p);
            k = p;
        }
    }


    boolean greaterThan(int i, int j) {
        Comparable e = (Comparable) elementData[i];
        return e.compareTo(elementData[j]) > 0;
    }

    void swap(int i, int j) {
        Object t = elementData[i];
        elementData[i] = elementData[j];
        elementData[j] = t;
    }

    public Object dequeue() {
        Object max = peek();
        elementData[0] = elementData[--size];
        elementData[size] = null;
        if (size > 1) fixDown(0);
        return max;
    }

    private void fixDown(int k) {
        int c;
        while ((c = 2 * k + 1) < size) {
            if (c + 1 < size && greaterThan(c + 1, c)) c++;
            if (!greaterThan(c, k)) break;
            swap(k, c);
            k = c;
        }
    }




}




