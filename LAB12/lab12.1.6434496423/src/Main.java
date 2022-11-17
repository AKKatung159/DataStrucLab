public class Main {
    public static void main(String[] args) {
       int[]a={5,2,12,9,1,8,7,18};
       MergeSort mergeSort=new MergeSort(a);
       mergeSort.mergeS();
       System.out.print("Merge sort : ");
       mergeSort.printS();
       int[]b={15,9,7,16,31,2,20,25,17,12};
       QuickSort quickSort=new QuickSort(b);
       quickSort.quickS();
        System.out.print("\nQuick sort : ");
        quickSort.printS();
    }
}