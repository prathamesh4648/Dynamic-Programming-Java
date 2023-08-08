public class DP18_partition_given_diff {
    public static int s(int arr[],int n,int k){
        int y=0;
        for(int j=0;j<arr.length;j++){
            y=y+arr[j];
        }
        return diff(n,arr,(y-k)/2);
    }
    public static int diff(int n,int arr[],int k){
        if(n==0){
            if(k==0 && arr[0]==0){return 2;}
            if(k==0 || arr[0]==k){return 1;}
            
            return 0;
        }

        int nottake=diff(n-1, arr,  k);
        int take=0;
        if(arr[n]<=k){
            take=diff(n-1, arr,  k-arr[n]);
        }
        return take+nottake;

    }
    public static void main(String args[]){
        int arr[]={0,0,1};
        System.out.println(s(arr, 3, 1 ));
    }
}
