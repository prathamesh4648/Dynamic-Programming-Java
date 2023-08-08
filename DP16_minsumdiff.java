
import java.util.*;
public class DP16_minsumdiff {
    public static int target(int n,int arr[],int t){
        int sum=0;
        for(int y=0;y<n;y++){
            sum=sum+arr[y];
        }
        int z=sum;
        boolean dp[][]=new boolean [n][z+1];
        for(boolean c[]:dp){
            Arrays.fill(c,false);
        }

        for(int k=0;k<n;k++){
            dp[k][0]=true;
        }
        if(arr[0]<=z){
            dp[0][arr[0]]=true;
        }
        

        for(int i=1;i<n;i++){
            for(int j=1;j<=z;j++){
                boolean nottake=dp[i-1][j];
                boolean take=false;
                if(arr[i]<=j){
                take=dp[i-1][j-arr[i]];
                }
                dp[i][j]=take||nottake;
            }
        }
        int min=(int)Math.pow(10,9);
        for(int l=0;l<=sum/2+1;l++){
            
            if(dp[n-1][l]==true){       
                min=Math.min(Math.abs(sum-l-l),min);
            }


        }

        

        return min;
    }



    public static void main(String args[]){
        int arr[]={1,2,3,4};
        System.out.println( target(4, arr, 0));
    }
    
}
