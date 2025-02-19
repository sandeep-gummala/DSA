import java.util.*;

public class JobScheduling{
    public static void  scheduling(Job jobs[]){
        Arrays.sort(jobs,(a,b)->b.profit-a.profit);
        int n=jobs.length,maxprofit=0;
        boolean[] slots=new boolean[n];
        Arrays.fill(slots,false);
        int[] result=new int[n];
        for(Job job:jobs){
            for(int j=job.deadline;j>=0;j--){
                if(!slots[j]){
                    slots[j]=true;
                    result[j]=job.id;
                    maxprofit+=job.profit;
                    break;
                }
            }
        }
        System.out.println("Selected Jobs are:");
        for(int i:result){
            if(i!=0){
                System.out.println("job "+i);
            }
        }

        System.out.println("total profit is: "+maxprofit);
    }
    public static void main(String[] args) {
        Job[] jobs={
            new Job(1,2,71),
            new Job(2,1,19),
            new Job(3,3,81),
            new Job(4,3,13),
        };
    scheduling(jobs);
    }
}

class Job{
    int id;
    int deadline,profit;
    public Job(int id,int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }    
}
