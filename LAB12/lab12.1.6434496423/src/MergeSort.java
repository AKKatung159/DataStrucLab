public class MergeSort {
    private int[]a;
    public MergeSort(int[] a){
        this.a=a;
    }
    public void mergeS(){
        mergeS(a,0,a.length-1);
    }
    private void mergeS(int[] array,int f,int l){
        int mid;
        if(f<l){
            mid=(f+l)/2;
            mergeS(array,f,mid);
            mergeS(array,mid+1,l);
            merge(array,f,mid,mid+1,l);
        }
    }
    private void merge(int[]array,int lf,int ll,int rf,int rl){
        int[] temp=new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            temp[i]=array[i];
//        }
        int i;
        int saveF;
        i=lf;
        saveF=lf;
        while (lf<=ll && rf<=rl){
            if(array[lf]>array[rf]){
                temp[i]=array[lf];
                lf++;
            }else {
                temp[i]=array[rf];
                rf++;
            }
            i++;
        }
        while (lf<=ll){
            temp[i]=array[lf];
            lf++;
            i++;
        }
        while (rf<=rl){
            temp[i]=array[rf];
            rf++;
            i++;
        }
        for (int j = saveF; j <=rl ; j++) {
            array[j]=temp[j];
        }
    }
    public void printS(){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }
}
