import java.util.Arrays;

public class DP11_triangle {
    public static int tri(int i,int j,int [][]c,int n){
        if(i==n-1){
            return c[n-1][j];
        }

        int d=c[i][j]+tri(i+1,j,c,n);
        int diago=c[i][j] + tri(i+1,j+1,c,n);
        return Math.min(d,diago);
    }


    // With Memoisation

    public static int tri(int i,int j,int [][]c,int n,int [][]dp){
        if(i==n-1){
            return c[n-1][j];
        }
        if(dp[i][j]!=-1){return dp[i][j];}
        int d=c[i][j]+tri(i+1,j,c,n);
        int diago=c[i][j] + tri(i+1,j+1,c,n);
        return dp[i][j]=Math.min(d,diago);
    }

    public static void main(String[] args){
        int c[][]={{1},{2,3},{3,6,7},{8,9,6,10}};
        int x[][]=new int [4][4];
        Arrays.stream(x).forEach(a ->Arrays.fill(a,0,3,-1));
        System.out.println(tri(0,0,c,4,x));
    }
}
