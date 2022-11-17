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
    public boolean contains (int data){
        BTNode s=root;
        while (s!=null){
            if(data==s.getElement()){
                return true;
            } else if (data>s.getElement()) {
                s=s.getRight();
            } else if (data<s.getElement()) {
                s=s.getLeft();
            }
        }
        return false;
    }
    public int getMax(){
        BTNode s=root;
        int ans=0;
        if(root==null){
            return ans;
        }
        while (s.getRight()!=null){
            s=s.getRight();
            ans=s.element;
        }
        return ans;
    }
    public int getMin(){
        BTNode s=root;
        int ans=0;
        if(root==null){
            return ans;
        }
        while (s.getLeft()!=null){
            s=s.getLeft();
            ans=s.element;
        }
        return ans;
    }
    public void remove(int element){
        BTNode s=root;
        BTNode p=root;
        while (s!=null&&s.getElement()==element){
            p=s;
            if (element>s.getElement()) {
                s=s.getRight();
            } else if (element<s.getElement()) {
                s=s.getLeft();
            }
        }
        if(s==null){
            System.out.println("ไม่เจอจ้า ไม่ทำ");return;
        }
        else {
            if(s.getLeft()==null&&s.getRight()==null){
                if(s==root){
                    root=null;
                } else if (p.getLeft()==s) {
                    p.setLeft(null);
                } else if (p.getRight()==s) {
                    p.setRight(null);
                }
            } else if (s.getLeft()!=null&&s.getRight()!=null) {
                BTNode q=s.getLeft();
                BTNode pq=s;
                while (q.getRight()!=null){
                    pq=q;
                    q=q.getRight();
                }
                s.setElement(q.getElement());
                if(pq!=s){
                    pq.setRight(q.getLeft());
                }else {
                    pq.setLeft(q.getLeft());
                }
            }
            else {
                if(s==root){
                    if(s.getLeft()!=null){
                        root=root.getLeft();
                    }
                    else if(s.getRight()!=null){
                        root=root.getRight();
                    }
                } else if (p.getLeft()==s) {
                    if(s.getLeft()!=null){
                        p.setLeft(s.getLeft());
                    }
                    else if(s.getRight()!=null){
                        p.setRight(s.getRight());
                    }
                } else if (p.getRight()==s) {
                    if(s.getLeft()!=null){
                        p.setLeft(s.getLeft());
                    }
                    else if(s.getRight()!=null){
                        p.setRight(s.getRight());
                    }
                }

            }
        }
    }
}