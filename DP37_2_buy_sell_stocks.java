
import java.util.*;

public class DP37_2_buy_sell_stocks {

    public static int stocks3(int n,int p[],int buy,int cap,int length){
        
       if(n==length){
        return 0;
       }

       if(cap==0){
        return 0;
       }
        if(buy==1){
            return Math.max(-(p[n])+stocks3(n+1,p,0,cap,length),0 + stocks3(n+1,p,1,cap,length));
        }
        else{
            return Math.max(p[n]+stocks3(n+1,p,1,cap-1,length),0 + stocks3(n+1,p,0,cap,length));
        }

    }

    // Using Memoisation

    public static int stocks3(int n,int p[],int buy,int cap,int length,int dp[][][]){
        
        if(n==length){
            return 0;
        }

        if(cap==0){
            return 0;
        }

        if(dp[n][buy][cap]!=-1){
            return dp[n][buy][cap];
        }


        if(buy==1){
            return dp[n][buy][cap]=Math.max(-(p[n])+stocks3(n+1,p,0,cap,length),0 + stocks3(n+1,p,1,cap,length));
        }
        else{
            return dp[n][buy][cap] = Math.max(p[n]+stocks3(n+1,p,1,cap-1,length),0 + stocks3(n+1,p,0,cap,length));
        }

    }
    public static int stock_y(int p[]){
        int length=p.length;
        int dp[][][]=new int [length][2][3];
        for(int a[][]:dp){
            for(int b[]:a){
                Arrays.fill(b,-1);
            }
        }

        return stocks3(0, p, 1, 2, length, dp);
    }
    public static void main(String args[]){
        

    }
}
