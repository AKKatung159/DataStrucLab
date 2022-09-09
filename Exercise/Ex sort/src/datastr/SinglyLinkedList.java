package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
public class SinglyLinkedList implements List {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode n) {
            this.element = e;
            this.next = n;
        }
    }
    private LinkedNode header;
    private int size;

    public SinglyLinkedList() {
        header = new LinkedNode(null, null);
        size = 0;
    }
    public boolean isEmpty() {
        return header.next == null;
    }
    public int size() {
        return size;
    }
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }
    public void add(Object e) {
        add(size, e);
    }
    public void add(int i, Object e) {
        LinkedNode p = nodeAt(i-1);
        p.next = new LinkedNode(e, p.next);
        ++size;
    }
    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }
    private void removeAfter(LinkedNode p) {
        if (p.next != null) {
            p.next = p.next.next;
            --size;
        }
    }
    public void remove(Object e) {
        LinkedNode p = header;
        while (p.next != null && !p.next.element.equals(e))
            p = p.next;
        removeAfter(p);
    }
    public void remove(int i) {
        LinkedNode p = nodeAt(i-1);
        removeAfter(p);
    }
    public Object get(int i) {
        return nodeAt(i).element;
    }
    public void set(int i, Object e) {
        nodeAt(i).element = e;
    }
    public void swap(int i,int j){
        Object k= nodeAt(i).element;
        nodeAt(i).element=nodeAt(j).element;
        nodeAt(j).element=k;
    }
    public void sorted(){
        int min;
        for (int i = 0; i < size; i++) {
            min=i;
            for (int j = min+1; j < size; j++) {
                if((Integer)nodeAt(min).element>(Integer) nodeAt(j).element){
                    min=j;
                }
            }
            swap(i,min);
        }
    }
    public  void reverse(){
        for (int i = 0; i < size/2; i++) {
            swap(i,size-1-i);
        }
    }
    public void removeRange(int m,int n){
        for (int i = m; i < n; i++) {
            remove(nodeAt(m).element);
        }
    }
    public int indexOf(Object e) {
        for (int i=0; i<size; i++)
            if (get(i).equals(e)) return i;
        return -1;
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        for (int i = 0; i < size; i++) {
            arr[i] = p.element;
            p = p.next;
        }
        return arr;
    }
}