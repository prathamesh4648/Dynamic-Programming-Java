import java.util.*;

public class DP47_no_of_lis {
    public static int nlis(int arr[],int n){
        int dp[]=new int[n];
        int count[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    count[i]=count[j];

                } 
                else if(arr[i]>arr[j] && dp[j]+1==dp[i]){
                    count[i]=count[j]+count[i];
                }
            }
            maxi=Math.max(maxi,dp[i]);

        }
        int cnt =0;
        for(int k=0;k<n;k++){
            if(dp[k]==maxi){
                cnt+=count[k];
            }
        }
        return cnt;
         
    }

    public static void main(String args[]){
        int arr[]={1,5,4,3,2,6,7,2,8,10};
       
        System.out.println(nlis(arr,8));
    }
}
