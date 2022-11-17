public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.add(3);
        tree.printTree();
        tree.add(1);
        tree.printTree();
        tree.add(2);
        tree.printTree();
        tree.add(4);
        tree.printTree();
        tree.add(8);
        tree.printTree();
        tree.add(15);
        tree.printTree();
        tree.remove(3);
        tree.printTree();
    }
}