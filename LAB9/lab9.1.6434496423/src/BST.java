

class BST {
    private BTNode root;

    BST(){
        this.root=null;
    }


    /**
     * @return the root
     */
    public BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(BTNode root) {
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
                    break;
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

    public int getMax() {
        BTNode s=root;
        if(root==null){
            return 0;
        }
        while (s.getRight()!=null){
            s=s.getRight();
        }
        return s.element;
    }

    public void remove(int newElement) {
        BTNode s=root;
        BTNode p=root;
        while (s!=null&&s.getElement()!=newElement){
            p=s;
            if (newElement>s.getElement()) {
                s=s.getRight();
            } else if (newElement<s.getElement()) {
                s=s.getLeft();
            }
        }
        if(s==null){
            System.out.println("not found");return;
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
                        p.setRight(s.getLeft());
                    }
                    else if(s.getRight()!=null){
                        p.setRight(s.getRight());
                    }
                }

            }
        }
    }
    public void InOrder(BTNode r){
        if(r!=null){
            InOrder(r.getLeft());
            System.out.print(r.getElement()+",");
            InOrder(r.getRight());
        }
    }
    public void printTree(){
        InOrder(root);
        System.out.println();
    }
//    public void remove(int newElement){
//        remove(root,newElement);
//    }
//    public void remove(BTNode node,int newElement){
//        if(node.getLeft().getElement()==newElement||node.getRight().getElement()==newElement){
//            if(node.getLeft().getElement()==newElement){
//                node.setLeft(node.getLeft());
//            }
//            else {
//
//            }
//        }
//        else {
//            remove(node.getRight(),newElement);
//            remove(node.getLeft(),newElement);
//        }
//    }
}


