import java.util.Arrays;

public class DP49_mcmtabulation {
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
        // System.out.println(mcm(arr,1,4));
        // System.out.println(memeo2(arr));
        
        System.out.println(mcmtab(arr,5));
    }
}
