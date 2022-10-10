package datastr;

public class BST {
    private BTNode root;
    public BST(){
        this.root=null;
    }

    /**
     * @return the root
     */
    private BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    private void setRoot(BTNode root) {
        this.root = root;
    }

    public void add(int newElement) {
        BTNode node = new BTNode(newElement,null,null);
        if(root==null){
            root=node;
        }
        else {
            BTNode s =root;
            BTNode p=root;
            while (s!=null){
                if((int)newElement>(int)s.getElement()){
                    p=s;
                    s=s.getRight();
                }
                else if ((int)newElement<(int)s.getElement()){
                    p=s;
                    s=s.getLeft();
                }
                else{
                    System.out.println("มีข้อมูลแล้ว");
                }
            }
            if((int)newElement>(int)p.getElement()){
                p.setRight(node);
            }
            else {
                p.setLeft(node);
            }
        }
    }

    public void printTree(BTNode r){
        if(r!=null){
            printTree(r.getLeft());
            System.out.println(r.getElement());
            printTree(r.getRight());
        }
    }
    public void printTree(){
        printTree(root);
    }
}