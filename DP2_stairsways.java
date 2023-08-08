package StriverDP;
import java.util.*;

public class DP2_stairsways {

    // Counting ways in which we can climb n stairs if 1 & 2 steps at a time allowed
    public static void stairs(int t, List <Integer> l,int c ,List <Integer> l1){

        if(t==0){
            // if(l.size()==0){
            //     System.out.println()
            // }
            l1.add(1);
            System.out.println(l);
            c++;
            // System.out.println(c);
            return  ;
        }
        if(t>=2){
            l.add(2);
            // c++;

            stairs(t-2,l,c,l1);
            l.remove(l.size()-1);    
            // c--;        /
        }    
        l.add(1);
        // c++;
        stairs(t-1,l,c,l1);
        l.remove(l.size()-1);
        // c--;
        

    }
    public static void main(String[] args)
    {
        List<Integer> l=new ArrayList<Integer>();
        List<Integer> l1=new ArrayList<Integer>();
        stairs(4 ,l,0,l1);
        System.out.println(l1.size());
    }
    
}
