import java.util.*;


public class DP48_MCM {
    public static int mcm(int arr[],int i,int j){
        if(i==j)return 0;
        int mini=Integer.MAX_VALUE;
        
        
        for(int k=i;k<j;k++){
            int steps=arr[i-1]*arr[k]*arr[j]+mcm(arr,i,k)+mcm(arr,k+1,j);
            mini=Math.min(mini,steps);
        }
        return mini;
    }


    //  Using Memoisation

    public static int mcmemo(int arr[],int i,int j,int dp[][]){
        if(i==j)return 0;
        int mini=Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        
        for(int k=i;k<j;k++){
            int steps= arr[i-1]*arr[k]*arr[j] +mcmemo(arr,i,k,dp) + mcmemo(arr,k+1,j,dp);
            mini=Math.min(mini,steps);
        }
        return dp[i][j]=mini;
    }

    public static int memeo2(int arr[]){
        int i=1;
        int j=arr.length-1;
        int dp[][]=new int [j+1][j+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return mcmemo(arr,i,j,dp);

    }
    public static int mcmtab(int arr[],int n){
       
        // int mini=Integer.MAX_VALUE;
        int dp[][]=new int [n][n];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }

        for(int k=0;k<n;k++){
            dp[k][k]=0;
        }
        
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<=n-1;j++){
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                int steps=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                mini=Math.min(mini,steps);
                }
                dp[i][j]=mini;
            }
            
        }
        return dp[1][n-1];
        
    }

    

    public static void main(String args[]){
        int arr[]={10,20,30,40,50};
        System.out.println(mcm(arr,1,4));
        System.out.println(memeo2(arr));
        
        System.out.println(mcmtab(arr,5));
    }
}
