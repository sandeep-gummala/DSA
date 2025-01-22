
class QuickSort{
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[low],i=low+1,j=high;
        while(i<=j){
            while(i<=j&& arr[i]<=pivot){
                i++;
            }
            while(i<=j&& arr[j]>=pivot){
                j--;
            }
            if(i<j)
                swap(arr, i, j);
        }
        swap(arr,j,low);
        return j;
    }
    public static void quicksort(int[] arr,int low,int high){
        if(low<high){
            int pivot=partition(arr,low,high);
            quicksort(arr, low, pivot-1);
            quicksort(arr, pivot+1, high);
        }
    }
    public static void main(String[] args) {
        int[] arr={9,3,16,82,9,1};
        int low=0,high=5;
        quicksort(arr, low, high);
        System.out.println("Array After Sorting: ");
        for(int i:arr){
            System.out.printf("%d\t",i);
        }
    }
}
