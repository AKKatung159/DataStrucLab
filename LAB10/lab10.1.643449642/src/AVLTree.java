public class AVLTree extends BST {
    public AVLTree(){
        super();
    }
    public void add(int newElement){
        AVLNode node =new AVLNode(newElement,null,null,0,0,0);
        if (getRoot()==null){
            setRoot(node);
        }
        else{
            ArrayStack stack=new ArrayStack();
            AVLNode s= (AVLNode) getRoot();
            AVLNode p;
            while (s!=null){
                stack.push(s);
                if(newElement>s.getElement()){
                    s= (AVLNode) s.getRight();
                }
                else {
                    s= (AVLNode) s.getLeft();
                }
            }
            p = (AVLNode) stack.pop();
            if (newElement<p.getElement()){
                p.setLeft(node);
            }
            else {
                p.setRight(node);
            }
            updateWeight(p);
            while (!stack.isEmpty()){
                AVLNode a = (AVLNode) stack.pop();
                updateWeight(a);
                p=rotate(p,a,stack);
            }
        }
    }
    public AVLNode rotate(AVLNode x, AVLNode y, ArrayStack stack) {
        AVLNode subroot = null;
        if (Math.abs(x.getWeight())>1) {
            if(x.getWeight()>0){//น้ำหนักเป็นบวกหมุนขวา
                if(y.getWeight()>0){
                    subroot = singleRight(x,y);//เครื่องหมายบวกหมุนหนึ่งครั้ง
                }
                else {
                    subroot = doubleRight(x,y);//เครื่องหมายลบหมุนสองครั้ง
                }
            }
            else {//น้ำหนักเป็นลบหมุนซ้าย
                if(y.getWeight()<0){
                    subroot = singleLeft(x,y);
                }
                else {
                    subroot = doubleLeft(x,y);
                }
            }
            if(stack.isEmpty()){
                setRoot(subroot);
            }
            else {
                AVLNode k= (AVLNode) stack.peek();
                if (subroot.getElement()<k.getElement()){
                    k.setLeft(subroot);
                }
                else{
                    k.setRight(subroot);
                }

                return subroot;
            }
        }
        return x;
    }
    public AVLNode singleRight(AVLNode x,AVLNode y){
        x.setLeft(y.getRight());
        y.setRight(x);
        updateWeight(x);
        updateWeight(y);
        return y;
    }
    public AVLNode doubleRight(AVLNode x,AVLNode y){
        AVLNode z= (AVLNode) y.getRight();
        y.setRight(z.getLeft());
        x.setLeft(z.getRight());
        z.setLeft(y);
        z.setRight(x);
        updateWeight(x);
        updateWeight(y);
        updateWeight(z);
        return z;
    }
    public AVLNode singleLeft(AVLNode x,AVLNode y){
        x.setRight(x.getLeft());
        y.setLeft(x);
        updateWeight(x);
        updateWeight(y);
        return y;
    }
    public AVLNode doubleLeft(AVLNode x,AVLNode y){
        AVLNode z= (AVLNode) y.getLeft();
        y.setLeft(z.getRight());
        x.setRight(z.getLeft());
        z.setLeft(x);
        z.setRight(y);
        updateWeight(x);
        updateWeight(y);
        updateWeight(z);
        return z;
    }
    public void updateWeight(AVLNode node){
        AVLNode r,l;
        r= (AVLNode) node.getRight();
        l= (AVLNode) node.getLeft();
        if (r==null){
            node.setRightHeight(0);
        }
        else {
            node.setRightHeight(1+Math.max(r.getRightHeight(),r.getLeftHeight()));
        }
        if (l==null){
            node.setLeftHeight(0);
        }
        else {
            node.setLeftHeight(1+Math.max(l.getRightHeight(),l.getLeftHeight()));
        }
        node.setWeight(node.getLeftHeight()-node.getRightHeight());
    }
    public void remove(int newElement){
        AVLNode s= (AVLNode) getRoot();
        AVLNode p= (AVLNode) getRoot();
        ArrayStack stack=new ArrayStack();
        while (s!=null&&s.getElement()!=newElement){
            stack.push(s);
            p=s;
            if (newElement>s.getElement()) {
                s= (AVLNode) s.getRight();
            } else if (newElement<s.getElement()) {
                s= (AVLNode) s.getLeft();
            }
        }
        if(s==null){
            System.out.println("not found");return;
        }
        else {
            if(s.getLeft()==null&&s.getRight()==null){
                if(s==getRoot()){
                    setRoot(null);
                } else if (p.getLeft()==s) {
                    p.setLeft(null);
                } else if (p.getRight()==s) {
                    p.setRight(null);
                }
            } else if (s.getLeft()!=null&&s.getRight()!=null) {
                AVLNode q= (AVLNode) s.getLeft();
                AVLNode pq=s;
                stack.push(q);
                while (q.getRight()!=null){
                    pq=q;
                    stack.push(q);
                    q= (AVLNode) q.getRight();
                }
                s.setElement(q.getElement());
                if(pq!=s){
                    pq.setRight(q.getLeft());
                }else {
                    pq.setLeft(q.getLeft());
                }
            }
            else {
                if(s==getRoot()){
                    if(s.getLeft()!=null){
                        setRoot(getRoot().getLeft());
                    }
                    else if(s.getRight()!=null){
                        setRoot(getRoot().getRight());
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
                stack.pop();
                AVLNode pq;
                while (!stack.isEmpty()) {
                    p = (AVLNode) stack.pop();
                    updateWeight(p);
                    if (Math.abs(p.getWeight()) > 1) {
                        if (p.getRightHeight() > p.getLeftHeight()) {
                            pq = (AVLNode) p.getRight();
                        }
                        else  {
                            pq = (AVLNode) p.getLeft();
                        }

                        rotate(p, pq, stack);
                    }
                }
            }
        }
    }
    public void printTree(){
        InOrder((AVLNode) getRoot());
        System.out.println();
    }
    public void InOrder(AVLNode node){
        if(node != null){
            InOrder((AVLNode) node.getLeft());
            System.out.print(node.getElement()+",");
            InOrder((AVLNode) node.getRight());
        }
    }
}
