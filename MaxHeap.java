
class MaxHeap{
    int A[];
    int maxsize,heapsize;
    MaxHeap(int maxsize){
        this.maxsize=maxsize;
        A=new int[maxsize];
        heapsize=0;
    }
    public int lchild(int i){
        return 2*i+1;
    }
    public int rchild(int i){
        return 2*i+2;
    }
    public int parent(int i){
        return (i-1)/2;
    }
    public void insertkey(int x){
        if(heapsize==maxsize){
            System.out.println("heap overflow");
        }
        int i=heapsize;
        A[i]=x;
        heapsize++;
        while(i!=0&&A[parent(i)]<A[i]){
            int temp=A[i];
            A[i]=A[parent(i)];
            A[parent(i)]=temp;
            i=parent(i);
        }
    }
    public void removeMax(){
        if(heapsize==0){
            System.out.println("Heap underflow");
        }
        else if(heapsize==1){
            heapsize--;
        }
        else{
            A[0]=A[heapsize-1];
            heapsize--;
            heapify(0);
        }
    }
    public void heapify(int i){
        int l=lchild(i);
        int r=rchild(i);
        int largest=i;
        if(l<heapsize&&A[l]>A[largest]){
            largest=l;
        }
        if(r<heapsize&&A[r]>A[largest]){
            largest=r;
        }
        if(largest!=i){
            int temp=A[i];
            A[i]=A[largest];
            A[largest]=temp;
            heapify(largest);
        }
    }
    public int getMax(){
        return A[0];
    }
    public int cursize(){
        return heapsize;
    }
    public static void main(String[] args) {
        MaxHeap ob=new MaxHeap(10);
        int arr[]={2,3,10,1,18,6,9};
        for(int k:arr){
            ob.insertkey(k);
        }
        System.out.println(ob.cursize());
        System.out.println(ob.getMax());
        ob.removeMax();
        System.out.println(ob.cursize());
        System.out.println(ob.getMax());
    }
}
