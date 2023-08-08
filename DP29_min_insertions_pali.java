public class DP29_min_insertions_pali {
    
    public static int palidp(String s1,String s2,int i1,int i2,int dp[][]){
        if(i1<0 ||i2<0){
            return 0;
        }
        if(dp[i1][i2]!=0){
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==(s2.charAt(i2))){return dp[i1][i2]= 1 + palidp(s1,s2,i1-1,i2-1,dp);}

        return dp[i1][i2]= Math.max(palidp(s1,s2,i1-1,i2,dp),palidp(s1, s2,i1,i2-1,dp));

    }
    public static int palidp2(String s1){
        
        StringBuilder s=new StringBuilder(s1);
        String s2=s.reverse().toString();
        int i1=s1.length()-1;
        int i2=s2.length()-1;
        int dp[][]=new int [i1+1][i2+1];
        return palidp(s1, s2, i1, i2,dp);
    }

    public static int min_ins(String s1){
        
        

        return s1.length()-palidp2(s1);

    }

    public static void main(String args[]){
        System.out.println(min_ins("abcaa"));
       
        
    }
}
