import java.util.*;

public class DP42b_print_lis {

    
    public static int printlis(int arr[],int dp[],int hash[],int n){
        int maxi=1;
        int lastidx=0;
        for(int i=0;i<n;i++){   
            hash[i]=i;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && (1+dp[j])>dp[i]){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
                lastidx=i;
            } 
            
            
            

        
        }
        
        int y[]=new int[maxi+1];
        y[0]=arr[lastidx];
        int ind=1;
        while(hash[lastidx]!=lastidx){
            
            lastidx=hash[lastidx];
            y[ind]=(arr[lastidx]);
            ind++;
        }
        
        for(int g=y.length-2;g>=0;g--){
            System.out.print(y[g] +" ");
        }
        System.out.println();
        return maxi;
        
    }
    public static int y(int arr[]){
        int n=arr.length;
        int hash[]=new int [n];
        
        int dp[]=new int [n];
        Arrays.fill(dp,1);
        return printlis(arr, dp, hash, n);
    
    }
    public static void main(String args[]){
        int arr[]={5,4,1,11,16,8,19,6,44};
        System.out.println(y(arr));
    }
}
