public class QuickSort {
    private int[] a;
    public QuickSort(int[] a){
        this.a=a;
    }
    public void quickS(){
        quickS(0,a.length-1);
    }
    private void quickS(int f,int l){
        int splitPoint;
        if(f<l){
            splitPoint=split(f,l);
            quickS(f,splitPoint-1);
            quickS(splitPoint+1,l);
        }
    }
    private int split(int f, int l){
        int pivot;
        boolean lessThanPivot;
        boolean qPivot;
        pivot=a[f];
        int saveF=f;
        f++;
        do {
            lessThanPivot=true;
            while ((f<=l) && lessThanPivot){
                if(a[f]>pivot){
                    f++;
                }
                else {
                    lessThanPivot=false;
                }
            }
            qPivot=true;
            while ((f<=l)&&qPivot){
                if(a[l]<pivot){
                    l--;
                }
                else {
                    qPivot=false;
                }
            }
            if(f<l){
                int temp=a[f];
                a[f]=a[l];
                a[l]=temp;
                f++;
                l--;
            }
        }
        while (f<=l);{
            int temp =a[saveF];
            a[saveF]=a[l];
            a[l]=temp;
        }
        return l;
    }
    public void printS(){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
