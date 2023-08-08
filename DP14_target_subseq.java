import java.util.*;

public class DP14_target_subseq {
    public static void target(int i, int k,int arr[], ArrayList<Integer> l1,ArrayList<ArrayList<Integer>> l){
        if(k==0){
            l.add(l1);
            System.out.println(l1);
            return;
            
        }
        if(i==arr.length || k<0){
            return;   
        }
        if(arr[i]<=k){
            l1.add(arr[i]);
            target(i+1,k-arr[i],arr,l1,l);
            l1.remove(l1.size()-1);
        }
        target(i+1,k,arr,l1,l);
        

    }

    public static boolean target(int n,int t,int[] arr){
        
        if(t==0){
            return true;
        }
        if(n==0){
            return (arr[0]==t);
        }

        boolean nottake=target(n-1,t,arr);
        boolean take=false;
        if(arr[n]<=t){
            take=target(n-1, t-arr[n], arr);
        }
        return take || nottake;

    }
    // Memoisation

    public static int tar(int n,int arr[],int t,int dp[][]){
        if(t==0)return 1;
        // if(n==0)return (int)arr[0]==t;
        if(n==0 && arr[0]==t) {return 1;} 
        if(n==0 && arr[0]!=t){return 0;}         
        if(dp[n][t]!=-1){return dp[n][t];}

        int take=0;
        int nottake=tar(n-1,arr,t,dp);
        if(arr[n]<=t){
            take=tar(n-1,arr,t-arr[n],dp);

        }
        return dp[n][t]=take + nottake;
    }
    public static int t(int arr[],int t){
        int n=arr.length;
        int dp[][]=new int [n][t+1];
        for(int y[]:dp){
            Arrays.fill(y,-1);

        }
        return tar(n-1, arr, t, dp);
    }

    public static void main(String args[]){
        int arr[]={1,2,2,3,};
        // ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        // ArrayList<Integer> l1=new ArrayList<>();
        // target(0,4,arr,l1,l);
        int dp[][]=new int[6][8];
        Arrays.stream(dp).forEach(a->Arrays.fill(a, 0, 0, -1));
        System.out.println(target(3,3,arr));
        System.out.println(t(arr, 3));
    }
}
