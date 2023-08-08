// package StriverDP;
import java.util.*;

public class DP7_Ninja {
    public static int ninjamax(int day,int last,int points,int [][]c){
        if(day==0){
            int max=0;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    max=Math.max(max,c[0][i]);
                }
                
            }
            return max;
        }
        int max=0;
        for(int j=0;j<=2;j++){
            if(j!=last){
                points=c[day][j] + ninjamax(day-1,j,points,c);
                max=Math.max(max,points);
            }
        }
        return max;
    }

    public static int ninja(int [][] m,int day,int last,int [][]v){
        if(day==0){
            int max=0;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    max=Math.max(max,m[0][i]);
                }
                
            }
            return max;
        }
        if(v[day][last]!=-1){return v[day][last];}
        int max=0;
        for(int j=0;j<=2;j++){
            if(j!=last){
                int points=m[day][j] + ninja(m,day-1,j,v);
                max=Math.max(max,points);
            }
        }
        return v[day][last]=max;
    }
    
    
    public static void main(String args[]) {
        int c[][]={{1,2,5},{3,1,1},{3,3,3}};
        int n=ninjamax(2, 3, 0, c);
        System.out.println(n);
        int v[][]=new int [3][3];
        // Arrays.fill(v,0,2,-1); 
        Arrays.stream(v).forEach(a -> Arrays.fill(a, -1));
        int y=ninja(c,2, 3, v);
        System.out.println(y);
    }
}
