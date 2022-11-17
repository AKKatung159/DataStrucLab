public class heap {
    private int[]a;
    private int numNode;
    public heap(int[]a){
        this.a=a;
        numNode=a.length-1;
    }
    public void buildHeap(){
        for (int i = numNode/2; i >= 1 ; i--) {
            reHeap(a,i,numNode);
        }
    }
    public void reHeap(int[]a,int root,int n) {
        int maxChild;//เก็บตำแหน่งลูกที่มากสุด
        boolean isheap =false;
        while (root*2<=numNode&&!isheap) {
            if (root * 2 == n) {//มีลูกซ้ายคนเดียว
                maxChild = root * 2;
            } else {
                if (a[root * 2] < a[root * 2 + 1]) {
                    maxChild = root * 2 + 1;
                } else {
                    maxChild = root * 2;
                }
            }
            if (a[root] < a[maxChild]) {
                int x = a[root];
                a[root] = a[maxChild];
                a[maxChild] = x;
                root = maxChild;
            }
            else {
                isheap=true;
            }
        }
    }

}
