import java.util.Arrays;
import java.util.*;
public class DP10_minpathsum {
    public static int upath(int m ,int n,int c[][]){
        if(m==0 && n==0){
            return c[0][0];
            
        }
        if(m<0 || n<0){
            return (int) Math.pow(10,9);
            // return Integer.MAX_VALUE;
        }
        
        
        
        int up=c[m][n]+ upath(m-1, n, c);
        int left=c[m][n]+upath(m,n-1,c);
        return Math.min(up,left);
}
    public static void main(String args[]){
        int c[][]={{1,3,1},{1,5,1},{4,2,1}};
        // int h[][]=new int[3][3];
        // Arrays.stream(h).forEach(a->Arrays.fill(a,-1));
        System.out.println(upath(2,2,c));
    }
}
