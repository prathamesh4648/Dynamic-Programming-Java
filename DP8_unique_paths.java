// package StriverDP;

import java.util.Arrays;

public class DP8_unique_paths {
    public static int paths(int i,int j){
        if(i==0 && j==0){
            return 1;

        }
        if(i<0 || j<0){
            return 0;

        }
        return paths(i-1,j)+paths(i, j-1);
    }
    
    // No.of unique paths to go from 0,0 to m,n
    // Using Memoization

    public static int paths(int i,int j,int [][] g){
        if(i==0 && j==0){
            return 1;

        }
        if(i<0 || j<0){
            return 0;

        }
        if(g[i][j]!=-1){
            return g[i][j];
        }
        return g[i][j]=paths(i-1,j)+paths(i, j-1);
    }

    // Using tabulation

    public static int pathstab(int m,int n,int [][] g){
        // g[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    g[0][0]=1;

                }
                else{
                    int up=0;
                    int left=0;
                    if(i>0) {up=g[i-1][j];}
                    if(j>0) {left=g[i][j-1];}
                    g[i][j]=up+left;
                }


            }
        }

        return g[m-1][n-1];
    }

    public static void main(String args[]){
        System.out.println(paths(2,2));
        int [][] g= new int [4][4];
        Arrays.stream(g).forEach(a->Arrays.fill(a,-1));
        // System.out.println(paths(3, 3 , g));
        System.out.println(pathstab(4, 4  , g));
    }
}
