package StriverDP;
import java.util.*;

public class DP3_frogjump {
    public static void frogj(int index,int target,int sum,int h[],List <Integer> l){
        if(target==0){
            System.out.println(sum);
            l.add(sum);
            
            return ;
        }
        if(target>=2){
            // l.add(2);
            sum=sum+Math.abs(h[index+2]-h[index]);
            frogj(index+1,target-2,sum,h,l);
            // l.remove(l.size()-1);
            sum=sum-Math.abs(h[index+2]-h[index]);
        }
        // l.add(1);
        sum=sum+Math.abs(h[index+1]-h[index]);
        frogj(index+1,target-1,sum,h,l);
        // l.remove(l.size()-1);
    }

    // In the  below code we started fromm the top instead of bottom as end height is important 
    // On every step we will jump on step with min energy between the 2 steps

    public static int f(int i,int t[],int h[],List<Integer> l){
        if(i==0){
            return 0;

        }
        if(t[i]!=-1){
            return t[i];
        }
        int left=f(i-1,t,h,l)+ Math.abs(h[i]-h[i-1]);

        int right=Integer.MAX_VALUE;
        if(i>1) right=f(i-2,t,h,l)+ Math.abs(h[i]-h[i-2]);
        return t[i]=Math.min(left ,right);
    }

    public static void main(String[] args){
        int t[]=new int[5];
        Arrays.fill(t, 0, 4, -1);
        // Arrays.fil
        int h[]={10,20,30,10};
        List<Integer> l=new ArrayList<>();
        // frogj(0, 3, 0, h, l);
        int g=f(3, t, h, l);
        System.out.println(g);
    }
    
}
