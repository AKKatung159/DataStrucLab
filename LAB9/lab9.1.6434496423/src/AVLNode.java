public class AVLNode extends BTNode {
    private int W;
    private int HL;
    private int HR;

    AVLNode(int element, AVLNode left, AVLNode right, int w, int hl, int hr) {
        super(element, left, right);
        W = w;
        HL = hl;
        HR = hr;
    }

    public int getW() {
        return W;
    }

    public int getHL() {
        return HL;
    }

    public int getHR() {
        return HR;
    }

    public void setW(int w) {
        W = w;
    }

    public void setHL(int hl) {
        HL = hl;
    }

    public void setHR(int hr) {
        HR = hr;
    }
}
