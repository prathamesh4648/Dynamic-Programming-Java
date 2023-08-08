package StriverDP;
import java.util.*;

public class DP1_fibonacci {


    public static int fibodp(int n,int g[]){
        
        
        if(n<=1){
            return n;
        }
        
        if(g[n]!=-1) {
        // {System.out.println(g[n]);
        return g[n];
        }
        g[n]=fibodp(n-1,g) + fibodp(n-2,g);
        return g[n];
        
        
         
    }

    // Here we used memoization technique to optimise space
    //  using 2 variables instead of an array of size n 
    public static void fibo_memo(int n){
      int prev1=0;
      int prev2=1;
      int curr=0;
      if(n<=1){
        System.out.println(n);
        return;
      }
      
      for(int i=2;i<=n;i++){
        curr=prev1+prev2;
        prev1=prev2;
        prev2=curr;


      }
      System.out.println(curr);
    }  


    public static void main(String[] args){
        fibo_memo(7);
        int n=2;
        int g[]=new int[n+1];
        Arrays.fill(g,0,n,-1);
        g[0]=0;
        g[1]=1;
        int o=fibodp(n,g);
        System.out.println(o);
    }
}
