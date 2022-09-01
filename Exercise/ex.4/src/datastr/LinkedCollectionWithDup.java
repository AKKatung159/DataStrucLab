package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

public class LinkedCollectionWithDup implements Collection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        int cnt;
        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
            this.cnt=0;
        }
        void addcnt(){
            cnt++;
        }
        void subcnt(){
            cnt--;
        }
    }
    private LinkedNode header = new LinkedNode(null, null);
    private int size;

    public LinkedCollectionWithDup() {}
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(Object e) {
        if(contains(e)){
            LinkedNode node = header.next;
            while( node != null ) {
                if (node.element.equals(e)) {
                    node.addcnt();
                    break;
                }
            }
        }
        else {
            header.next = new LinkedNode(e, header.next);
        }
        ++size;
    }
    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while( node != null ) {
            if (node.element.equals(e)) return true;
            node = node.next;
        }
        return false;
    }
    public void remove(Object e) {
        LinkedNode p = header;
        while( p.next != null && ! p.next.element.equals(e)) {
            p = p.next;
        }
        if (p.next != null&& p.next.cnt==0) {
            p.next = p.next.next;
            --size;
        }
        else if(p.next != null&& p.next.cnt!=0){
            p.next.subcnt();
            --size;
        }
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        int k = 0;
        while (p != null) {
            for (int i = 0; i < p.cnt+1; i++) {
                arr[k] = p.element;
                k++;
            }
            p = p.next;
        }
        return arr;
    }
    public String toString(){
        String line="";
        for (int i = 0; i < size; i++) {
            line+=toArray()[i];
            if(i<size-1){
                line+=", ";
            }
        }
        return line;
    }
}
