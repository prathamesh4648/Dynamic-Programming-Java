import java.util.Arrays;

public class DP41_longest_inc_subseq {
    public static int lic(int ind ,int prev,int arr[],int n){
        if(ind==n){
            return 0;
        } 

        int len= 0 + lic(ind+1, prev, arr,n);
        // This prev==-1 is helpful when not taken cases(above line case) coz theres no element at index=-1
        // if elements are not taken until 4th element and now we want to take the next element than this condition helps as our prev index is still -1.
        if(prev==-1  || arr[ind]>arr[prev]){
            len=Math.max(1+ lic(ind +1,ind ,arr,n),len);
        }
        return len;
    }

    public static int lic2(int arr[]){
        int n=arr.length;
        int ind=0;int prev=-1;
        return lic(ind, prev, arr, n);
    }

    // Using Memoisation
    // DP


    public static int licmemo(int ind ,int prev,int arr[],int dp[][],int n){
        if(ind==n){
            return 0;
        }
        if(dp[ind][prev+1]!=-  1){
            return dp[ind][prev+1];
        }

        int not= 0 + licmemo(ind+1, prev, arr,dp,n);
        int take=0;
        if(prev==-1  || arr[ind]>arr[prev]){
            take=1+ licmemo(ind +1,ind ,arr,dp,n);
        }
        return dp[ind][prev+1]=Math.max(take,not);
        
        

    }
    public static int licmemo2(int arr[],int n){
        
        
        int dp[][]=new int[n][n+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }

        return licmemo(0, -1, arr,dp,n);
    }


    // 2nd method
    public static int lisdp(int arr[],int n,int dp[]){
        int maxi=1;
        for(int i=0;i<n;i++){
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }

            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }

    public static int lisdp2(int arr[]){
        int n=arr.length;
        int dp[]=new int [n];
        Arrays.fill(dp,1);
        return lisdp(arr, n, dp);
    }

    public static void main(String args[]){
        int arr[]={10,9,2,5,3,7,101,18};
        System.out.println(lic2(arr));
        System.out.println(licmemo2(arr,8));

        System.out.println(lisdp2(arr));
        
    }
}
