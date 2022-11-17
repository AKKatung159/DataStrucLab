public class Heap {
    private int[] array;
    private int numNode;
    public Heap(int[] a){
//        array=a;
        array=new int[a.length+1];
        array[0]=0;
        for (int i = 0; i < a.length; i++) {
            array[i+1]=a[i];
        }
        numNode=array.length-1;
    }
    public void buildHeap(){
        for (int i = numNode/2; i >0 ; i--) {
            reHeap(i);
            printHeap();
        }
    }
    public void reHeap(int root){
        int maxChild;//ตน.ลูกมากสุด
        boolean isHeap=false;
        while ((2*root<=numNode)&&(!isHeap)){
            if (root * 2 == numNode) {//มีลูกซ้ายคนเดียว
                maxChild = root * 2;
            } else {
                if (array[root * 2] > array[root * 2 + 1]) {
                    maxChild = root * 2;
                } else {
                    maxChild = root * 2+1;
                }
            }
            if (array[root] < array[maxChild]) {
                int x = array[root];
                array[root] = array[maxChild];
                array[maxChild] = x;
                root = maxChild;
            }
            else {
                isHeap=true;
            }
        }
    }
    public void printHeap(){
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
