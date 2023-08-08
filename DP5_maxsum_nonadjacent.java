package StriverDP;

public class DP5_maxsum_nonadjacent {
    public static int maxsum(int idx,int arr[],int pick,int notpick){
        if(idx==0){
            return arr[idx];
        }
        if(idx<0){
            return 0;
        }
        pick=arr[idx]+maxsum(idx-2, arr, pick, notpick);

        notpick=0 + maxsum(idx-1, arr,pick, notpick);

        return Math.max(pick, notpick);
    }

    // With DP Memoisation
    public static int maxsum(int idx,int arr[],int pick,int notpick,int x[]){
        if(idx==0){
            return arr[idx];
        }
        if(idx<0){
            return 0;
        }
        if(x[idx]!=-1){
            return x[idx];
        }
        pick=arr[idx]+maxsum(idx-2, arr, pick, notpick,x);


        notpick=0 + maxsum(idx-1, arr,pick, notpick,x);

        return x[idx]=Math.max(pick, notpick);
    }


    // With Tabulation and space optimisation

    public static int maxsum(int arr[]){
        int prev2=0; 
        int prev=arr[0];

        for(int i=1;i<arr.length;i++){
            int take=arr[i];
            if(i>1) {take=take + prev2;}
            int nottake=0+prev;
            int curr=Math.max(take, nottake);

            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String args[]) {
        int arr[]={1,2,4,9};

        int u=maxsum(3, arr, 0, 0);
        System.out.println(u);
        int y=maxsum(arr);
        System.out.println(y);
    }
}
