import datastr.BST;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(3);         tree.add(1);         tree.add(2);         tree.add(8);         tree.add(15);         tree.printTree();
        System.out.println(tree.contains(20));
        System.out.println(tree.getMax());
        System.out.println(tree.getMin());
    }
}