
import java.util.*;

public class DP23_unbounded_knapsack {
    public static int unboundedknap(int n,int w[],int v[],int t){
        if(n==0){
            if(t%w[0]==0){return t/w[0]*v[0];}
            return 0;
            

        }

        int not=unboundedknap(n-1,w,v,t);
        int take=Integer.MIN_VALUE;
        if(w[n]<=t){
            take=v[n]+ unboundedknap(n,w,v,t-w[n]);
        }
        return Math.max(take,not);
    }

    // Using Memoisation DP

    public static int unboundedknapdp(int n,int w[],int v[],int t,int dp[][]){
        if(n==0){
            if(t%w[0]==0){return t/w[0]*v[0];}
            return 0;
            

        }
        if(dp[n][t]!=-1){
            return dp[n][t];
        }

        int not=unboundedknapdp(n-1,w,v,t,dp);
        int take=Integer.MIN_VALUE;
        if(w[n]<=t){
            take=v[n]+ unboundedknapdp(n,w,v,t-w[n],dp);
        }
        return dp[n][t]= Math.max(take,not);
    }

    public static int knapdp(int w[],int v[],int t){
        int n=w.length;
        int dp[][]=new int [n][t+1];
        for(int a[]:dp){Arrays.fill(a,-1);}
        System.out.println(unboundedknapdp(n-1,w,v,t,dp));
        return unboundedknapdp(n-1,w,v,t,dp);
    }

    public static void main(String args[]){
        int w[]={2,4,6};
        int v[]={6,11,17};

        System.out.println(unboundedknap(2,w,v,10));
        knapdp(w,v,10);
    }
}
