import java.util.*;

public class DP24_rod_cutting_pblm {
    public static int rod(int ind,int n,int p[]){

        if(ind==0){
            return p[0]*n;
        }

        int not=rod(ind-1,n,p);
        int take=Integer.MIN_VALUE;
        if(ind+1<=n){
            take=p[ind]+rod(ind,n-ind-1,p);
        }

        return Math.max(take,not);

    }

    public static int rodmemo(int ind,int n,int p[],int dp[][]){

        if(ind==0){
            return p[0]*n;
        }

        if(dp[ind][n]!=-1){return dp[ind][n];}

        int not=rodmemo(ind-1,n,p,dp);
        int take=Integer.MIN_VALUE;
        if(ind+1<=n){
            take=p[ind]+rodmemo(ind,n-ind-1,p,dp);
        }

        return dp[ind][n]=Math.max(take,not);

    }

    public static int rodm(int n,int p[]){
        int ind=p.length;

        int dp[][]=new int [ind][n+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return rodmemo(ind-1,ind,p,dp); 
       }

    public static void main(String args[]){
        int p[]={3,5,8,9,10,17,17,20};
        System.out.println(rod(7,8,p));
        System.out.println(rodm(8,p));
         
    }
}
