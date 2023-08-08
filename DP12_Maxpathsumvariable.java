import java.util.Arrays;

public class DP12_Maxpathsumvariable {
    public static int maxvar(int i,int j,int [][]c,int n){
        if(j<0 || j>=4){return -(int)Math.pow(10,8);}
        if(i==0){
            return c[0][j];
        }
         
        int d=c[i][j]+maxvar(i-1,j,c,n);
        int l=c[i][j] + maxvar(i-1,j-1,c,n);
        int r=c[i][j] + maxvar(i-1,j+1,c,n);
        return Math.max(d,Math.max(l, r));
        
    }
    public static int ma(int [][]c,int i,int n){
        int maxi=-(int)Math.pow(10, 8);
        for (int j=0;j<4;j++){
            maxi=Math.max(maxi, maxvar(i-1,j,c,n));
        }
        return maxi;
    }

    public static void main(String args[]){
        int c[][]={{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        int x[][]=new int [4][4];
        Arrays.stream(x).forEach(a ->Arrays.fill(a,0,3,-1));
        maxvar(3, 3, c, 4);
        System.out.println(ma(c,4,4));
    }
}
