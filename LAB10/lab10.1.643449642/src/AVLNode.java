public class AVLNode extends BTNode{
    private int weight,leftHeight,rightHeight;
    AVLNode(int element, BTNode left, BTNode right,int w,int hl,int hr) {
        super(element, left, right);
        weight=w;
        rightHeight=hr;
        leftHeight=hl;
    }

    public int getLeftHeight() {
        return leftHeight;
    }

    public int getRightHeight() {
        return rightHeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
    }

    public void setRightHeight(int rightHeight) {
        this.rightHeight = rightHeight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
