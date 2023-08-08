import java.util.Arrays;

public class DP9_uniquepaths2 {
    public static int upath(int m ,int n,int c[][],int h[][]){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(m>=0 && n>=0 && c[m][n]==-1){
            return 0;
        }
        if(h[m][n]!=-1){
            return h[m][n];
        }
        int up=upath(m-1, n, c, h);
        int left=upath(m,n-1,c,h);
        return h[m][n]=up+left;

        

    }
    public static void main(String args[]){
        int c[][]={{0,0,0},{0,-1,0},{ 0,0,0}};
        int h[][]=new int[3][3];
        Arrays.stream(h).forEach(a->Arrays.fill(a,-1));
        System.out.println(upath(2,2,c,h));
    }
}
