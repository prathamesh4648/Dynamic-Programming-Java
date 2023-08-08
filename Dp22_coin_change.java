import java.util.Arrays;

public class Dp22_coin_change {
    public static int coinchng(int n,int arr[],int t){
        if(n==0){
            if(t==0){return 1;}
            while(arr[0]<=t ){
                t=t-arr[0];
                if(t==0){
                    return 1;
                }
            }
            return 0;
        }

        int not=coinchng(n-1,arr,t);
        int take=0;
        if(arr[n]<=t){
            take=coinchng(n, arr, t-arr[n]);
        }

        return take+not;
    }

    public static int coinchngdp(int n,int arr[],int t,int dp[][]){
        if(n==0){
            if(t==0){return 1;}
            while(arr[0]<=t ){
                t=t-arr[0];
                if(t==0){
                    return 1;
                }
            }
            return 0;
        }

        if(dp[n][t]!=-1){return dp[n][t];}

        int not=coinchngdp(n-1,arr,t,dp);
        int take=0;
        if(arr[n]<=t){
            take=coinchngdp(n, arr, t-arr[n],dp);
        }

        return dp[n][t]=take+not;
    }

    public static int cc(int arr[],int t){
        int n=arr.length;
        int dp[][]=new int[n][t+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return coinchngdp(n-1,arr,t,dp);

    }

    public static void main(String args[]){
        int arr[]={1,2,3,4};
        System.out.println(coinchng(3,arr, 4));
        System.out.println(cc(arr, 4));
    }
    
}
