
class MergeSort{
    public static void Merge(int[] arr,int low,int mid,int high){
        int i=low,j=mid+1,k=i;
        int[] b=new int[high+1];
        while(i<=mid&&j<=high){
            if(arr[i]<arr[j]){
                b[k++]=arr[i++];
            }
            else{
                b[k++]=arr[j++];
            }
        }
        while(i<=mid){
            b[k++]=arr[i++];
        }
        while(j<=high){
            b[k++]=arr[j++];
        }
        for(int l=low;l<=high;l++){
            arr[l]=b[l];
        }
    }
    public static void mergesort(int[] arr,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            Merge(arr, low, mid, high);
        }
    }
    public static void main(String[] args) {
        int[] arr={45,2,72,25,1};
        int low=0,high=arr.length-1;
        mergesort(arr, low, high);
        for(int k:arr){
            System.out.println(k);
        }
    }
}
