public class Main {
    public static void main(String[] args) {
       Heap heap=new Heap(new int[]{20, 9, 32, 6, 15, 25, 50, 5, 8, 13, 18});
//        System.out.print("data : ");
//       heap.printHeap();
       heap.buildHeap();
//        System.out.print("heap : ");
//       heap.printHeap();
    }
}