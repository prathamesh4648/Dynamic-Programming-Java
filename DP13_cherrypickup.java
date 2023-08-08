public class DP13_cherrypickup {
    public static int cherry(int i,int j1,int j2,int n,int a[][]){
        if(i==n-1){
            if(j1==j2){
                return a[i][j1];

            }
            else{
                return a[i][j1]+a[i][j2];
            }

        }
        int maxi=0;
        for(int l=-1;l<=1;l++){
            for(int r=-1;r<=1;r++){
                if(j1==j2){
                    maxi=Math.max(maxi,a[i][j1]+cherry(i, j1+l, j2+r, n, a));
                }
                else{
                    maxi=Math.max(maxi,a[i][j2] +  a[i][j1]+cherry(i, j1+l, j2+r, n, a));
                }
                
            }
        }
        return maxi;
    }
    
    public static void main(String args[]){
        int a[][]={{2,4,1,2},{3,4,2,2},{5,6,3,5}};
        System.out.println(cherry(0, 0, 3, 2, a));
    }
}
