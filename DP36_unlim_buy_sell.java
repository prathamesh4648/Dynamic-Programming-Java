

public class DP36_unlim_buy_sell {
    public static int buy_sell(int p[],int buy,int ind,int n){
        if(ind ==n){
            return 0;
        }
        int profit=0;
        if(buy==1){
            profit= Math.max(-(p[ind]) + buy_sell(p, 0, ind+1,n),(0 +buy_sell(p, 1, ind+1,n)));
        }
        else{
            profit=Math.max(p[ind]+ buy_sell(p, 1, ind+1,n),0+ buy_sell(p, 0, ind+1,n)) ;  
        }
        return profit;
    }

    public static void main(String args[]){
        int p[]={7,1,5,3,6,4};
        System.out.println(buy_sell(p, 1, 0,6 ));
    }
}
