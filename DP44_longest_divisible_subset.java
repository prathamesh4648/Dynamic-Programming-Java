
import java.util.*;

public class DP44_longest_divisible_subset {
    public static int div(int arr[],int n,int dp[],int hash[]){
        int maxi=1;
        int lastidx=0;
        for (int i = 0; i < arr.length; i++) {
            hash[i]=i;
            for (int j = 0; j < i; j++) {
                if(arr[i]%arr[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
                
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastidx=i;

            }
            
        }
        List <Integer > l=new ArrayList<Integer> ();
        l.add(arr[lastidx]);
        while(hash[lastidx]!=lastidx){
            lastidx=hash[lastidx];
            l.add(arr[lastidx]);

        }

        System.out.println(l);
        return maxi;
    }

    public static int y(int arr[]){
        int n=arr.length;
        int hash[]=new int [n];
        
        int dp[]=new int [n];
        Arrays.fill(dp,1);
        return div(arr, n, dp,hash);
    
    }
    public static void main(String args[]){
        int arr[]={1,4,7,8,16,88};
        System.out.println(y(arr));   
    }
}
