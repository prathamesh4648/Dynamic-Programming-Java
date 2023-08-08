public class DP28_Longest_palindromic_subseq {
    public static int pali(String s1,String s2,int i1,int i2){
        if(i1<0 ||i2<0){
            return 0;
        }
        if(s1.charAt(i1)==(s2.charAt(i2))){return 1 + pali(s1,s2,i1-1,i2-1);}

        return Math.max(pali(s1,s2,i1-1,i2),pali(s1, s2,i1,i2-1));

    }
    public static int pali2(String s1){
        StringBuilder s=new StringBuilder(s1);
        String s2=s.reverse().toString();
        int i1=s1.length()-1;
        int i2=s2.length()-1;
        return pali(s1, s2, i1, i2);
        
        
    }
    // Memoisation DP


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
    


    public static void main(String args[]){
        System.out.println(pali2("bbbab"));
        System.out.println(pali2("bbabcbcab"));
        System.out.println(palidp2("bbabcbcab"));
        System.out.println(pali2("bbbab"));

    }
    
}
