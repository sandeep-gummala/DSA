
class MinHeap{
    int A[];
    int maxsize,heapsize;
    MinHeap(int maxsize){
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
        while(i!=0&&A[parent(i)]>A[i]){
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
        int smallest=i;
        if(l<heapsize&&A[l]<A[smallest]){
            smallest=l;
        }
        if(r<heapsize&&A[r]<A[smallest]){
            smallest=r;
        }
        if(smallest!=i){
            int temp=A[i];
            A[i]=A[smallest];
            A[smallest]=temp;
            heapify(smallest);
        }
    }
    public int getMin(){
        return A[0];
    }
    public int cursize(){
        return heapsize;
    }
    public static void main(String[] args) {
        MinHeap ob=new MinHeap(10);
        int arr[]={2,3,10,1,18,6,9};
        for(int k:arr){
            ob.insertkey(k);
        }
        System.out.println(ob.cursize());
        System.out.println(ob.getMin());
        ob.removeMax();
        System.out.println(ob.cursize());
        System.out.println(ob.getMin());
    }
}
