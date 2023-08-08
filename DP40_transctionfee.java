import java.rmi.StubNotFoundException;

public class DP40_transctionfee{
    public static int buy_sell(int p[],int buy,int ind,int n){
        if(ind ==n){
            return 0;
        }
        int profit=0;
        if(buy==1){
            profit= Math.max(-(p[ind]) + buy_sell(p, 0, ind+1,n),(0 +buy_sell(p, 1, ind+1,n)));
        }
        else{
            profit=Math.max(p[ind]+ buy_sell(p, 1, ind+1,n)-2,0+ buy_sell(p, 0, ind+1,n)) ;  
        }
        return profit;
    }

    public static void main (String args[]){
        int p[]={1,3,2,8,4,9};
        
        System.out.println(buy_sell(p, 1, 0, 6));
    }
}