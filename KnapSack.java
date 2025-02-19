
import java.util.Arrays;


class Item{
    int profit,weight;
    double ratio;
    public Item(int weight,int profit){
        this.profit=profit;
        this.weight=weight;
        this.ratio=(double)this.profit/this.weight;
    }
}
public class KnapSack{
    public static void knapsack(Item[] items,int m){
        Arrays.sort(items,(a,b)->Double.compare(a.ratio, b.ratio));
        int maxprofit=0;
        for(Item item:items){
            if(item.weight<=m){
                maxprofit+=item.profit;
                System.out.println("The item with weight :"+item.weight+" and profit: "+item.profit+"is filled fully");
                m-=item.weight;
            }
            else{
                double fraction=(double)m/item.weight;
                System.out.println("Item Selected:(Weight: "+item.weight*fraction+" and Profit: "+item.profit*fraction+")-taken "+fraction*100+"%");
                maxprofit+=item.profit*fraction;
                break;
            }
        }
        System.out.println("maxprofit: "+maxprofit);
    }
    public static void main(String[] args) {
        Item[] items={
            new Item(10,60),
            new Item(20,100),
            new Item(30,120)
        };
        int m=45;
        knapsack(items, m);
    }
}
