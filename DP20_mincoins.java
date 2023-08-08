
import java.util.*;
public class DP20_mincoins {
    public static int coins(int n,int c[],int sum,int count){
        if(n==0){
            if(sum%c[0]==0){
                return sum/c[0];
                
            }
            return (int)Math.pow(10,9);
        }

        int nottake=0 +  coins(n-1,c,sum,count);
        int take=Integer.MAX_VALUE;
        if(c[n]<=sum){
            count++;
            take=1+coins(n, c, sum-c[n], count);
        }

        
        return Math.min(take,nottake);
    }

    public static int coinsdp(int n,int c[],int sum,int count,int dp[][]){
        if(n==0){
            if(sum%c[0]==0){
                return sum / c[0];

            }
            return (int)Math.pow(10, 9);
        }
        if(dp[n][sum]!=-1){return dp[n][sum];}

        int nottake=0 +  coinsdp(n-1,c,sum,count,dp);
        int take=Integer.MAX_VALUE;
        if(c[n]<=sum){
            count++;
            take=1+coinsdp(n, c, sum-c[n], count,dp);
        }

        
        return dp[n][sum] = Math.min(take,nottake);
    }
    

    public static void main(String args[]){
        int arr[]={3,3,5,2,1};
        int dp[][]=new int [arr.length][10];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        System.out.println(coins(4, arr, 9, 0));
        System.out.println(coinsdp(4, arr, 9, 0,dp));
    }
}
