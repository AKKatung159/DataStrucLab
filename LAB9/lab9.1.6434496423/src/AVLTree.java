import java.util.Stack;

public class AVLTree extends BST{
    public AVLTree(){
        super();
    }
    public void add(int newElement) {
        AVLNode node=new AVLNode(newElement,null,null,0,0,0);
        if(getRoot()==null){
            setRoot(node);
        }
        else {
            ArrayStack stack =new ArrayStack();
            AVLNode s= (AVLNode) getRoot();
            stack.push(s);
            while (s!=null){
                if(newElement>s.getElement()){
                    s= (AVLNode) s.getRight();
                } else if (newElement<s.getElement()) {
                    s= (AVLNode) s.getLeft();
                }
                else {
                    break;
                }
            }
            AVLNode p = (AVLNode) stack.pop();
            if (newElement<p.getElement()){
                p.setLeft(node);
            }
            else {
                p.setRight(node);
            }
            while (!stack.isEmpty()){
                updateWeight(p);
                AVLNode a = (AVLNode) stack.pop();
                updateWeight(a);
                p=rotate(a,p,stack);
            }
        }
    }
    public void remove(int newElement){

    }
    public AVLNode rotate(AVLNode x,AVLNode y,ArrayStack stack){
        AVLNode subroot;
        if(Math.abs(x.getW())>1){
            if(x.getW()>0){
                if(y.getW()>0){
                    subroot = singleRight(x,y);
                }
            }
            else {
                if(y.getW()<0){
                    subroot = doubleRight(x,y);
                }
            }
            if(stack.isEmpty()){
                setRoot(subroot);
            }
            else {
                AVLNode k= (AVLNode) stack.peek();
                if (subroot.getElement()<k.getElement()){
                    k.setLeft()(subroot);
                }
            else{
                    k.setRight(subroot);
                }

                return subroot;
            }
        }
        else return x;
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
    public void updateWeight(AVLNode node){
        AVLNode r,l;
        r= (AVLNode) node.getRight();l= (AVLNode) node.getLeft();
        if(r==null){
            node.setHR(0);
        }
        else {
            if(r.getHR()>r.getHL()){
                node.setHR(1+r.getHR());
            }
            else {
                node.setHR(1+r.getHL());
            }
        }
        if(l==null){
            node.setHL(0);
        }
        else {
            if(r.getHL()>r.getHR()){
                node.setHL(1+r.getHL());
            }
            else {
                node.setHL(1+r.getHR());
            }
        }
        node.setHL(node.getHL()-node.getHR());
    }
}
