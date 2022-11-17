public class sort {
    private int[] array;int n;
    public sort(int[] a,int n){
        array=a;
        this.n=n;
    }
    public void selectionS(){
        for (int i = 0; i < n-1; i++) {//จำนวนรอบ ตัวบนสุด
            int top= array[i];int min=array[i];int minIndex=i;
            for (int j = i+1; j < n; j++) {
                if(min>array[i]){
                    min=array[i];
                    minIndex=i;
                }
            }
            int temp=array[i]
            array[i]=min;
            array[minIndex]=temp;

        }
    }
    public void bubbleS(){

    }
    public void quickS(int[] a,int f,int l){
        int splitpoint;
        if(f<l){
            splitpoint=split(a,f,l);
            quickS(a,f,splitpoint-1);
            quickS(a,splitpoint,l);
        }
//        privote >first <last
//                swapfirst last
//     last<first
//             split last
//                     privot swap
    }
    public int split(int[] a, int f, int l){
        int pivot;
        boolean lessthanpivot
        pivot=a[f];
        f++;
        do {
            lessthanpivot=true;
        }
        while (f<=l && lessthanpivot){

        }
        lessthanpivot=false;
        pivot=
    }
    public int[] mergeS(int[] array,int f,int l){
        int mid;
        if(f<l){
            mid=(f+l)/2;
            mergeS(array,f,mid);
            mergeS(array,mid+1,l);
            merge(array,f,mid,mid+1,l);
        }
    }
    public void merge(int[]array,int lf,int ll,int rf,int rl){
        int[] temp=new int[array.length];
        int i,int savelf;
        i=lf;
        savelf=lf;
        while (lf<=ll&&rf<=rl){
            if(array[lf]<array[rf]){
                temp[i]=array[lf];
                lf++;
            }else {
                temp[i]=array[rf];
                rf++;
            }
        }
        while (lf<ll){
            temp[i]=array[lf];
            lf++;
            i++;
        }
        while (rf<rl){
            temp[i]=array[rf];
            rf++;
            i++;
        }
        for (int j = savelf; j <=rl ; j++) {
            array[j]=temp[j];
        }
    }
}
