package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

public class LinkedCollection implements Collection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
        }
    }
    private LinkedNode header = new LinkedNode(null, null);
    private int size;

    public LinkedCollection() {}
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(Object e) {
        header.next = new LinkedNode(e, header.next);
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
        while( p.next != null &&
                ! p.next.element.equals(e)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next; --size;
        }
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        int k = 0;
        while (p != null) {
            arr[k++] = p.element;
            p = p.next;
        }
        return arr;
    }

    @Override
    public boolean equals(Object x) {
        if(x instanceof LinkedCollection){
            if(this.size== ((LinkedCollection) x).size()){
                for (int i = 0; i < ((LinkedCollection) x).size(); i++) {
                    if(!this.contains(((LinkedCollection) x).toArray()[i])){
                        return false;
                    }
                }
                for (int i = 0; i < this.size; i++) {
                    if(!((LinkedCollection) x).contains(this.toArray()[i])){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    public boolean containsDup() {
        LinkedCollection x = new LinkedCollection();
        LinkedNode node2 = header.next;
        while (node2!=null){
            x.add(node2.element);
            node2=node2.next;
        }
        LinkedNode node = header.next;
        while( node != null ) {
            if (x.contains(node.element)){
                x.remove(node.element);
                boolean ans=x.contains(node.element);
                x.add(node.element);
                if(ans) {
                    return ans;
                }
            }
            node = node.next;
        }
        return false;
    }
    public void removeDup(){
        LinkedNode node2 = header.next;
        while (node2!=null){
            this.removeAll(node2.element);
            this.add(node2.element);
            node2=node2.next;
        }
    }
    public void removeAll(Object x){
        LinkedNode node = header.next;
        while( node != null ) {
            if (this.contains(x)) {
                this.remove(x);
            }
            node=node.next;
        }
    }

}
