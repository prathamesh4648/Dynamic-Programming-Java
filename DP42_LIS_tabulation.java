
import java.util.*;

public class DP42_LIS_tabulation {
    public static int listab(int arr[],int n,int dp[][]){
        for (int ind = n-1; ind >=0 ; ind--) {
            for(int prev=ind-1;prev>=-1;prev--){
                int not=0+dp[ind+1][prev+1];
                if(prev==-1 || arr[ind]>arr[prev]){
                    not=(Math.max(not,dp[ind+1][ind+1]+1));
                }
                dp[ind][prev+1]=not;
            }
        }

        return dp[0][0];
    }

    public static int listab2(int arr[],int n){
        int dp[][]=new int [n+1][n+1];
        for(int a[]:dp){
            Arrays.fill(a,0);
        }
        return listab(arr, n, dp);
    }

    public static void main(String args[]){
        int arr[]={10,9,2,5,3,7,101,18};
        System.out.println(listab2(arr,8));
    }
}
