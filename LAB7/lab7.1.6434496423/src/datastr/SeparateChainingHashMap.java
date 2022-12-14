package datastr;

import java.util.Arrays;
import java.util.LinkedList;

public class SeparateChainingHashMap implements Map {
    private static class LinkedNode {
        Object key, value;
        LinkedNode next;
        LinkedNode(Object k, Object v, LinkedNode n) {
            key = k; value = v; next = n;
        }
    }
    private int size;
    private LinkedNode[] table;
    public SeparateChainingHashMap(int cap) {
        table = new LinkedNode[cap];
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public Object get(Object key) {
        LinkedNode node = getNode(key);
        return node == null ? null : node.value;
    }
    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }
    private LinkedNode getNode(Object key) {
        LinkedNode cur = table[h(key)];
        while (cur != null && !cur.key.equals(key)) {
            cur = cur.next;
        }
        return cur;
    }
    private int h(Object x) {
        return Math.abs(x.hashCode()) % table.length;
    }
    public Object put(Object key, Object value) {
        LinkedNode node = getNode(key);
        Object oldValue = null;
        if (node != null) {
            oldValue = node.value;
            node.value = value;
        } else {
            int h = h(key);
            table[h] = new LinkedNode(key, value, table[h]);
            ++size;
            if (size > table.length/2) rehash();
        }
        return oldValue;
    }
    public void remove(Object key) {
        int h = h(key);
        if (table[h] == null) return;
        if (table[h].key.equals(key)) {
            table[h] = table[h].next; --size;
        } else {
            LinkedNode prev = table[h];
            while (prev.next != null && !prev.next.key.equals(key)) {
                prev = prev.next;
            }
            if (prev.next != null) {
                prev.next = prev.next.next; --size;
            }
        }
    }
    public String toString() {
        String ans="";
        for (int i = 0; i < this.table.length; i++) {
            if(table[i]!=null)
            {
                ans+="["+i+"]\t=> "+table[i].value+"\n";
            }
            else {
                ans+="["+i+"]\n";
            }
        }
        return ans;
    }
    private void rehash() {
        LinkedNode[] oldT = table;
        table = new LinkedNode[2 * table.length];
        for (int i = 0; i < oldT.length; i++) {
            if (oldT[i] != null) {
                this.put(oldT[i].key,oldT[i].value);
            }
        }
    }
}
//    private void rehash() {
//        LinkedList[] oldTable = table;
//        table = new LinkedList[2 * table.length];
//        for (int i = 0; i < table.length; i++)
//            table[i] = new LinkedList();
//        for (int i = 0; i < oldTable.length; i++) {
//            Object[] items = oldTable[i].toArray();
//            for (int j = 0; j < items.length; j++) {
//                table[h(items[j])].add(0, items[j]);
//            }
//        }
//    }