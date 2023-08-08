package StriverDP;

public class DP6_robber {
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

        int u=maxsum(arr);
        System.out.println(u);
        int y=maxsum(arr);
        System.out.println(y);
    }
}
