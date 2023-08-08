
import java.util.*;
public class DP21_sum_using_sign{
    public static int sign(int n,int arr[],int sum,int t){
        if(n==0){
            if(sum+arr[0]==t){return 1;}
            if(sum-arr[0]==t){return 1;}
            if(sum==t){
                return 1;

            }
            return 0;
        }

        int positive=sign(n-1, arr, sum+arr[n],t);
        int negative=sign(n-1, arr, sum-arr[n], t);

        return positive + negative;
    }



    // public static int sign(int n,int arr[],int t,int dp[][]){
    //     if(n==0){
    //         if(t-arr[0]==0){return 1;}
    //         if(t+arr[0]==0){return 1;}
    //         if(t==0){
    //             return 1;

    //         }
    //         return 0;
    //     }
    //     if(dp[n][t]!=-1){return dp[n][t];}

    //     int positive=sign(n-1, arr, t+arr[n],dp);
    //     int negative=sign(n-1, arr,  t-arr[n],dp);

    //     return dp[n][t]= positive + negative;
    // }
    // public static int sumsign(int arr[],int t){
    //     int sum=0;  
    //     for(int i= 0;i<arr.length;i++){
    //         sum=sum+arr[i];
    //     }   
    //     int n=arr.length;
    //     int dp[][]=new int[n][sum+1];
    //     for(int a[]:dp){
    //         Arrays.fill(a,-1);
    //     }
    //     return sign(n-1, arr, t, dp);
    // }
    public static void main(String args[]){
        int arr[]={1,2,3,4};
        System.out.println(sign(3,arr,0,4));
        // System.out.println(sumsign(arr, 3 ));
    }
}